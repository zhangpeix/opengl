package opengl;

/**
 * g开头表示一组的开始，后面的字符串为此组的名字。
 * 所谓组是指由顶点组成的一些面的集合，只包含g的行表示一组的结束
 */
public class ObjModel {
	/**
	 * 顶点坐标
	 */
	private float[] v;
	/**
	 * 纹理坐标
	 */
	private float[] vt;
	/**
	 * 顶点法向量
	 */
	private float[] vn;
	
	public float[] getV() {
		return v;
	}
	public void setV(float[] v) {
		this.v = v;
	}
	public float[] getVt() {
		return vt;
	}
	public void setVt(float[] vt) {
		this.vt = vt;
	}
	public float[] getVn() {
		return vn;
	}
	public void setVn(float[] vn) {
		this.vn = vn;
	}
	
	
}
