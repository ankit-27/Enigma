import java.util.Scanner;
public class Enigma
{
	public static void main( String[] args )
	{

		String out="";

		Scanner input = new Scanner( System.in );
		Rotor rotor = new Rotor();
		PlugBoard board = new PlugBoard();
		char k1,k2,k3,k4,pb;
		int count1=0,count2=0,count3=0,count4=0;
		/*rotor.setRotor('C','U','Q','J');
		System.out.printf("%c",rotor.encrypt('L'));
		rotor.setRotor('C','U','Q','K');
		System.out.printf("%c",rotor.encrypt('L'));*/
		System.out.printf("Enter a four digit key(in CAPITALS) : ");
		String key = input.nextLine();
                k1=key.charAt(0);
                k2=key.charAt(1);
                k3=key.charAt(2);
                k4=key.charAt(3);
		rotor.setRotor(k1,k2,k3,k4);

		//getSetting for plugboard
		System.out.printf("Manual PlugBoard Settings(Y/N): ");
		pb = input.nextLine().charAt(0);
		if(pb=='Y')
		{
			System.out.printf("Enter PlugBoard Sequence:\n");
			for(int i=0;i<5;i++)
			{
				System.out.printf("%d. ",i);
				String pb1=input.nextLine();
				board.getSetting(pb1.charAt(0),pb1.charAt(1));
			}
		}


		System.out.printf("Enter your message: ");
		String msg = input.nextLine();
		for(int i=0;i<msg.length();i++)
		{
			if(msg.charAt(i)==32)
			{
				System.out.printf(" ");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
				continue;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			}
			char board1 = board.pbOutput(msg.charAt(i));
			char encrypt = rotor.encrypt(board1);
			char board2 = board.pbOutput(encrypt);
			out = out + board2;

			//set new rotor position
            count4++;
            k4=(char)(k4+1);
            if(k4>90)
            	k4='A';
            if(count4==26)
            {
            	count3++;
            	count4=0;
            	k3=(char)(k3+1);
            	if(k3>90)
            		k3='A';
            	if(count3==26)
            	{
            		count2++;
            		count3=0;
            		k2=(char)(k2+1);
            		if(k2>90)
            			k2='A';
            		if(count2==26)
            		{
            			count1++;
            			count2=0;
            			k1=(char)(k1+1);
            			if(k1>90)
            				k1='A';
            		}
            	}
            }
            rotor.setRotor(k1,k2,k3,k4);
            
		}
                                                                                                                                                                                                                                                                                                                 
		System.out.print(out);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		
	}
}