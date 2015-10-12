package opengl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadObjVertex {
	public static ObjModel loadModel(String path) throws IOException{
		ObjModel objModel=new ObjModel();
		List<Float> unSortv=new ArrayList<Float>();
		List<Float> unSortvt=new ArrayList<Float>();
		List<Float> unSortvn=new ArrayList<Float>();
		List<Point> list=new ArrayList<Point>();
		/**
		 * 顶点数组索引
		 */
		BufferedReader br=new BufferedReader(new FileReader(path));
		String line=null;
		while((line=br.readLine())!=null){
			String[] strs=line.split("[ ]+");
			if("vt".equals(strs[0])){
				unSortvt.add(Float.valueOf(strs[1]));
				unSortvt.add(Float.valueOf(strs[2]));
			}else if("vn".equals(strs[0])){
				unSortvn.add(Float.valueOf(strs[1]));
				unSortvn.add(Float.valueOf(strs[2]));
				unSortvn.add(Float.valueOf(strs[3]));
			}else if("v".equals(strs[0])){
				unSortv.add(Float.valueOf(strs[1]));
				unSortv.add(Float.valueOf(strs[2]));
				unSortv.add(Float.valueOf(strs[3]));
			} else if("f".equals(strs[0])) {
				list.add(getPoint(strs[1]));
				list.add(getPoint(strs[2]));
				list.add(getPoint(strs[3]));
			}
		}
		if(list.size()>0){
			float[] v=new float[list.size()*3];
			float[] vn=null;
			if(unSortvn.size()>0){
				vn=new float[list.size()*3];
			}
			float[] vt=null;
			if(unSortvt.size()>0){
				vt=new float[list.size()*3];
			}
			int i=0;
			int j=0;
			int k=0;
			for(Point p:list){
				int index=p.v-1;
				v[i++]=unSortv.get(3*index);
				v[i++]=unSortv.get(3*index+1);
				v[i++]=unSortv.get(3*index+2);
				if(vn!=null){
					index=p.vn-1;
					vn[j++]=unSortvn.get(3*index);
					vn[j++]=unSortvn.get(3*index+1);
					vn[j++]=unSortvn.get(3*index+2);
				}
				if(vt!=null){
					index=p.vt-1;
					vt[k++]=unSortvt.get(3*index);
					vt[k++]=unSortvt.get(3*index+1);
					vt[k++]=unSortvt.get(3*index+2);
				}
			}
			objModel.setV(v);
			objModel.setVn(vn);
			objModel.setVt(vt);
		}
		return objModel;
	}
	private static Point getPoint(String str){
		String[] f=str.split("/");
		Point p=new Point();
		p.v=Integer.valueOf(f[0]);
		if(f.length==2&&f[1]!=null&&f[1].length()>0){
			p.vt=Integer.valueOf(f[1]);
		}
		if(f.length==3&&f[2]!=null&&f[2].length()>0){
			p.vn=Integer.valueOf(f[2]);
		}
		return p;
	}
	static class Point{
		/*
		 * 顶点
		 */
		Integer v;
		/*
		 * 法向量
		 */
		Integer vn;
		/*
		 * 纹理
		 */
		Integer vt;
	}
}
