package section8;
class Sample2_06_2 {
	public void main (String[] args) {
		
		double bottom = 3.0 ; //底辺
		double height = 7.0 ; //高さ
		
		System.out.println( "三角形の面積：" + calcSizeTriangle( bottom , height ) );
	}
	
	//三角形の面積を戻り値として返す
	//（第1引数：底辺、第2引数：高さ）
	double calcSizeTriangle(double bottom , double height){
		return bottom * height / 2 ;
	}
}

