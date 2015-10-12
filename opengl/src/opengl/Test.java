package opengl;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		ObjModel objModel=LoadObjVertex.loadModel("F:/soft/(源代码)Android3D游戏开发技术宝典-OpengGL ES2.0 吴亚峰著/第10章 混合与雾/Sample10_1a/assets/ch.obj");
		StringBuilder sb=new StringBuilder("{");
		sb.append("\"v\":").append("[");
		float[] v=objModel.getV();
		for(int i=0;i<v.length;i++){
			sb.append(v[i]).append(",");
		}
		sb.delete(sb.length()-1, sb.length());
		sb.append("]");
		float[] vt=objModel.getVt();
		if(vt!=null&&vt.length>0){
			sb.append(",").append("\"vt\":");
			for(int i=0;i<vt.length;i++){
				sb.append(vt[i]).append(",");
			}
			sb.delete(sb.length()-1, sb.length());
			sb.append("]");
		}
		float[] vn=objModel.getVn();
		if(vn!=null&&vn.length>0){
			sb.append(",").append("\"vn\":");
			for(int i=0;i<vn.length;i++){
				sb.append(vn[i]).append(",");
			}
			sb.delete(sb.length()-1, sb.length());
			sb.append("]");
		}
		sb.append("}");
		
		System.out.println(sb.toString());
	}

}
