/*************************************************************/
/*Represents a number in Digital Format*/
/*Author @ Krishnakanth Soni */

/*Usage: java DigitalStyle <numberlist>*/
/*Example: java DigitalStyle 124 256 5895 1236*/
/*************************************************************/
public class DigitalStyle
{
	private int fontSize;

	public DigitalStyle(){
		fontSize = 2;
	}

	public boolean setFontSize( int fontSize ){
		if( fontSize >= 2 ){
			this.fontSize = fontSize;
			return true;
		}
		return false;
	}
	
	//flag[0] = Top Line
	//flag[1] = Top Left
	//flag[2] = Top Right
	//flag[3] = Middle
	//flag[4] = Bottom left
	//flag[5] = Bottom Right
	//flag[6] = Bottom Line
	private String[] printZero(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		flag[3] = false;
		return printDigitalStyle(flag);
	}

	private String[] printOne(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		flag[0] = false;
		flag[1] = false;
		flag[3] = false;
		flag[4] = false;
		flag[6] = false;
		return printDigitalStyle(flag);
	}

	private String[] printTwo(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		flag[1] = false;
		flag[5] = false;
		return printDigitalStyle(flag);
	}

	private String[] printThree(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		flag[1] = false;
		flag[4] = false;
		return printDigitalStyle(flag);
	}

	private String[] printFour(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		flag[0] = false;
		flag[4] = false;
		flag[6] = false;
		return printDigitalStyle(flag);
	}

	private String[] printFive(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		flag[2] = false;
		flag[4] = false;
		return printDigitalStyle(flag);
	}

	private String[] printSix(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		flag[2] = false;
		return printDigitalStyle(flag);
	}

	private String[] printSeven(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		flag[1] = false;
		flag[3] = false;
		flag[4] = false;
		flag[6] = false;
		return printDigitalStyle(flag);
	}

	private String[] printEight(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		return printDigitalStyle(flag);
	}

	private String[] printNine(){
		boolean flag[] = new boolean[7];
		for( int i=0; i<flag.length; i++ ){
			flag[i] = true;
		}
		flag[4] = false;
		return printDigitalStyle(flag);
	}

	private String[] getNumber( int number ){
		switch(number){
			case 1:
				return printOne();
			case 2:
				return printTwo();
			case 3:
				return printThree();
			case 4:
				return printFour();
			case 5:
				return printFive();
			case 6:
				return printSix();
			case 7:
				return printSeven();
			case 8:
				return printEight();
			case 9:
				return printNine();
			case 0:
				return printZero();
		}
		String[] result = new String[1];
		result[0] = "Invalid";
		return result;
	}

	private String[] printDigitalStyle( boolean[] flag ){
		String digit[] = new String[ (fontSize*2) + 3 ];
		//Top
		int currentIndex = 0;
		digit[currentIndex] = " ";
		for( int i=1; i<=fontSize; i++ )
			if( flag[0] )
				digit[currentIndex] += "-";
			else
				digit[currentIndex] += " ";
		digit[currentIndex] += " ";
		currentIndex++;
		//left and right legs
		for( int i=1; i<=fontSize; i++ ){
			digit[currentIndex] = "";
			if( flag[1] )
				digit[currentIndex] += "|";
			else
				digit[currentIndex] += " ";
			for( int j=1; j<=fontSize; j++ )
				digit[currentIndex] += " ";
			if( flag[2] )
				digit[currentIndex] += "|";
			else
				digit[currentIndex] += " ";
			currentIndex++;
		}
		//middle
		digit[currentIndex] = " ";
		for( int i=1; i<=fontSize; i++ )
			if( flag[3] )
				digit[currentIndex] += "-";
			else
				digit[currentIndex] += " ";
		digit[currentIndex] += " ";
		currentIndex++;
		//left and right legs
		for( int i=1; i<=fontSize; i++ ){
			digit[currentIndex] = "";
			if( flag[4] )
				digit[currentIndex] += "|";
			else
				digit[currentIndex] += " ";
			for( int j=1; j<=fontSize; j++ )
				digit[currentIndex] += " ";
			if( flag[5] )
				digit[currentIndex] += "|";
			else
				digit[currentIndex] += " ";
			currentIndex++;
		}
		//bottom
		digit[currentIndex] = " ";
		for( int i=1; i<=fontSize; i++ )
			if( flag[6] )
				digit[currentIndex] += "-";
			else
				digit[currentIndex] += " ";
		digit[currentIndex] += " ";
		return digit;
	}

	public String[] getDigital( int number )
	{
		String result[] = new String[ (fontSize*2) + 3 ];
		String num = "" + number;
		String nums[][] = new String[num.length()][];
		
		for( int i=0; i<num.length(); i++ ){
			nums[i] = getNumber( Integer.parseInt(num.charAt(i) + "") );
		}

		for( int i=0; i<result.length; i++ ){
			result[i] = "";
			for( int j=0; j<nums.length; j++ )
				result[i] += nums[j][i] + " ";
		}
		return result;
	}

	public String getDigitalInString( int number ){
		String digital[] = getDigital( number );
		String result = "";
		for( int i=0; i<digital.length; i++ )
			result += digital[i] + "\n";
		return result;
	}

	public static void main(String[] args) 
	{
		DigitalStyle ds = new DigitalStyle();
		ds.setFontSize(2);
		if( args.length >= 1 ){
			for( int i=0; i<args.length; i++ ){
				try{
					String[] digit = ds.getDigital(Integer.parseInt(args[i]));
					for( int j=0; j<digit.length; j++ )
						System.out.println( digit[j] );
					System.out.println( "\n" );
				}catch(Exception e){}
			}
			System.exit(0);
		}
		int a[] = { 23, 4567, 3424, 9898, 5065 };
		for( int i=0; i<a.length; i++ ){
			String[] digit = ds.getDigital(a[i]);
			for( int j=0; j<digit.length; j++ )
				System.out.println( digit[j] );
			System.out.println( "\n" );
		}
	}
}
