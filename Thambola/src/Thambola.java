import java.util.*;
import java.io.*;

public class Thambola
{
	private ThambolaList finishedNumbers = null;
	private Random randomGenerator = null;
	private File archiveFile = null;
	private String directory = "";
	private String fileName = "";

	public Thambola(){
		finishedNumbers = new ThambolaList();
		randomGenerator = new Random();
		directory = System.getProperty( "user.home" ) + System.getProperty( "file.separator" ) + "KKThambola" + System.getProperty( "file.separator" ) + "Archive" + System.getProperty( "file.separator" );
		fileName = "archive.file";
		archiveFile = new File( directory + fileName );
	}
	
	public void displayFinishedNumbers(){
		String display[] = new String[9];
		for( int i=0; i<9; i++ )
			display[i] = "";
		for( int i=0; i<finishedNumbers.size(); i++ ){
			if( Integer.parseInt( finishedNumbers.get(i).toString() ) <= 10 )
				display[0] = display[0] + finishedNumbers.get(i).toString() + ", "; 
			else if( Integer.parseInt( finishedNumbers.get(i).toString() ) <= 20 )
				display[1] += finishedNumbers.get(i).toString() + ", "; 
			else if( Integer.parseInt( finishedNumbers.get(i).toString() ) <= 30 )
				display[2] += finishedNumbers.get(i).toString() + ", "; 
			else if( Integer.parseInt( finishedNumbers.get(i).toString() ) <= 40 )
				display[3] += finishedNumbers.get(i).toString() + ", "; 
			else if( Integer.parseInt( finishedNumbers.get(i).toString() ) <= 50 )
				display[4] += finishedNumbers.get(i).toString() + ", "; 
			else if( Integer.parseInt( finishedNumbers.get(i).toString() ) <= 60 )
				display[5] += finishedNumbers.get(i).toString() + ", "; 
			else if( Integer.parseInt( finishedNumbers.get(i).toString() ) <= 70 )
				display[6] += finishedNumbers.get(i).toString() + ", "; 
			else if( Integer.parseInt( finishedNumbers.get(i).toString() ) <= 80 )
				display[7] += finishedNumbers.get(i).toString() + ", "; 
			else if( Integer.parseInt( finishedNumbers.get(i).toString() ) <= 90 )
				display[8] += finishedNumbers.get(i).toString() + ", "; 
		}
		System.out.println( "\n\n\n\n\n\n - - - - - - - - - - - - - - - - - - - - - -" );
		System.out.println( "|        F I N I S H D N U M B E R S        |" );
		System.out.println( " - - - - - - - - - - - - - - - - - - - - - - " );
		System.out.println( "|                                           |");
		for( int i=0; i<display.length; i++ )
			if( ! display[i].equals( "" ) )
				System.out.println( "|  " + display[i] );
		//System.out.println( new String( "                                           " ).length() );
		System.out.println( "|                                           |");
		System.out.println( " - - - - - - - - - - - - - - - - - - - - - -" );
	}

	public void displayMenu(){
		System.out.println( "\n - - - - - - - - - - - - - - - - - - - " );
		System.out.println( "|          M A I N   M E N U          |" );
		System.out.println( " - - - - - - - - - - - - - - - - - - - " );
		System.out.println( "|     1. Gnereate Ticket              |" );
		System.out.println( "|     2. NextNumber                   |" );
		System.out.println( "|     3. DisplayFinishedNumbers       |" );
		System.out.println( "|     4. DisplayWinningConditions     |" );
		System.out.println( "|     5. Finish Game                  |" );
		System.out.println( "|                                     |" );
	}
public void displayWinningConditions(){
	System.out.println("1. Top Line: all numbers in 1st row are cut");
	System.out.println("2. Middle Line: all numbers in 2nd row are cut");
	System.out.println("3. Bottom Line: all numbers in 3rd row are cut");
	System.out.println("4. Corners: 1st and last number of 1st and 3rd row are cut");
	System.out.println("5. Full House: all numbers in ticket are cut");
}
	public void playThambola(){
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		if( archiveFile.exists() ){
			System.out.print( "\n\nLast Game is Not Completed, Do You Want to Continue (Y/N) : " );
			try{
				String choice = br.readLine();
				if( ! ( choice.startsWith( "N" ) || choice.startsWith( "n" ) ) ){
					ObjectInputStream os = new ObjectInputStream( new FileInputStream( archiveFile ) );
					this.finishedNumbers = (ThambolaList)os.readObject();
				}
			}catch( Exception e ){}
		}
		else{
			try{
				archiveFile = new File( directory );
				archiveFile.mkdirs();
				archiveFile = new File( directory + fileName );
				archiveFile.createNewFile();
			}catch( Exception e ){ System.out.println( e.getMessage() );}
		}
		
		
		System.out.println( "\\  T A M B O L A  \\" );
		
		int choice = 1;
		
		
		DigitalStyle ds = new DigitalStyle();
		TicketGenerator tg = new TicketGenerator();
		Ticket t;
		while( choice != 5 ){
			if( finishedNumbers.size() == 90 ){
				System.out.println( "END" );
				break;
			}

			displayMenu();

			while(true){
				System.out.print( "|Enter your Choice : " );
				try{
					choice = Integer.parseInt( br.readLine() );
					if( choice <=0 || choice >= 6 )
						continue;
					else
						break;
				}catch( Exception e ){
					continue;
				}
			}
			
			switch( choice ){
			case 1:
				System.out.println("enter number of players");
				Scanner n = new Scanner(System.in);
				int a = n.nextInt();
				for(int j = 0 ; j<a ; j++){
				
				t = tg.generateTicket();
				System.out.println(t);}
				try{
					System.out.print( "\nPress Any Key To Continue ..." );
					br.readLine();
				}catch(Exception e){}
				break;	
			case 2:
					int number = next();
					System.out.println( "\n\nNumber is : " + number + "\n\n" );

					try{
						br.readLine();
					}catch(Exception e){}
					break;
				case 3:
					displayFinishedNumbers();
					try{
						System.out.print( "\nPress Any Key To Continue ..." );
						br.readLine();
					}catch(Exception e){}
					break;
				case 4:
//					System.out.println("1. Top Line: all numbers in 1st row are cut");
//					System.out.println("2. Middle Line: all numbers in 2nd row are cut");
//					System.out.println("3. Bottom Line: all numbers in 3rd row are cut");
//					System.out.println("4. Corners: 1st and last number of 1st and 3rd row are cut");
//					System.out.println("5. Full House: all numbers in ticket are cut");
					displayWinningConditions();
					try{
						System.out.print( "\nPress Any Key To Continue ..." );
						br.readLine();
					}catch(Exception e){}
					break;
				case 5:
					if( finishedNumbers.size() != 90 && finishedNumbers.size() != 0 ){
						try{
							System.out.print( "\n\nDo You Want to Save this Game (Y/N) : " );
							String c1 = br.readLine();
							//System.out.println( choice1 );
							if( c1.startsWith( "n" ) || c1.startsWith( "N" ) )
								if( archiveFile.delete() )
								{}	
						}catch( Exception e ){ 
							System.out.println( e.getMessage() );
						}
					}else{
						if( archiveFile.delete() )
						{}
					}
					System.out.println( "The End" );
					System.exit(0);
			}
		}

		displayFinishedNumbers();
	}
	
	public List getFinishedNumberList(){
		return this.finishedNumbers;
	}

	public int next(){
		boolean counter = true;

		while( counter ){
			int nextNumber = randomGenerator.nextInt( 91 );
			
			if( nextNumber == 0 )
				continue;

			String number = "" + nextNumber;

			if( number.length() == 1 )
				number = "0" + number;
		
			if( finishedNumbers.contains( number ) )
				continue;

			finishedNumbers.add( number );

			Collections.sort( finishedNumbers );
			try{
				ObjectOutputStream fos = new ObjectOutputStream( new FileOutputStream( archiveFile ) );
				fos.writeObject( finishedNumbers );
				fos.close();
			}catch( Exception e ){}
			return nextNumber;
		}

		return -1;
	}

	public static void main( String args[] ){
		Thambola t = new Thambola();
		t.playThambola();
	}
}
