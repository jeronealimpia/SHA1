package sha1;


public class SHA1 {

    public static void main(String[] args) {
    
    String Message = "1A7FD53B4C";
    char MessageArray[] = Message.toCharArray();
    int MessageSize = MessageArray.length;
    
    String Padding = AddZero(MessageSize,119); //Adding Zero Padding's
    int Bit64 = Message.length()*4; //Getting the 64-bit message to be appended to the end of zero's 
    String Hex64 = Long.toHexString(Bit64); //Convert to Hexadecimal Value
    String Zeros = AddZero(Message.length(),16); //Append Zero on 64-bit message
    String NewHex64 = (Zeros+Hex64);
    String MessagePadding=(Message+8+Padding+NewHex64); //Message + 1Bit Value + 0's Paddding + 64Bit 1Bit Value (Total 128 character)
    
    //System.out.println(MessagePadding);
    
   char PaddedMessage[]=MessagePadding.toCharArray(); 
   int W[] = new int[80]; //Creation of W[0]->W[79] 
   int k=0; //Initial value for J
    int l=8; //Range value for J

    for(int i=0;i<16;i++){ //Assignment of W[0]->W[16]          
        String Temp=""; 
        for(int j=k;j<l;j++){ 
        Temp +=PaddedMessage[j];     
        }
        k=l;
        l=l+8;
        W[i]=Integer.decode("0x"+Temp);
    }
   
       
 
 int c=0;
 for(int i=16;i<80;i++){ 
 int XOR=W[0+c]^W[2+c]^W[8+c]^W[13+c];
 String Temp = Integer.toBinaryString(XOR<<1);
 Long parse = Long.parseLong(Temp,2);
 W[i]=parse.intValue();
 c++; 
 }

   for(int i=0;i<W.length;i++){ 
   String HexStr = Integer.toHexString(W[i]);
   System.out.println("W"+i+"="+HexStr);
   } 
  
/*
int table[]={58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7};
int EBit[]={32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,31,32,1};
String PText="1234567890ABCDEF";
long Decimal=Long.decode("0x"+PText);
String Binary=Long.toBinaryString(Decimal);
String Zero = AddZero(Binary.length(),64);
String NewBinary=Zero+Binary;

char Bin[]=NewBinary.toCharArray();

    for(int i=0;i<64;i++){
    Bin[i]=Bin[table[i]-1];        
    }
    
    String L="",R="";
    for(int i=0;i<64;i++){
        if(i<32){
        R+=Bin[i];
        }else{
        L+=Bin[i];
        }
    }
    
    char Right[]=R.toCharArray();
    
    char Left[]=L.toCharArray();
    
    for(int i=0;i<48;i++){
    Right[i]=Right[EBit[i]-1];        
    }
    
    for(char x:Right){
    System.out.print(x);
    }
    
    
    /*for(char x:Bin){
    System.out.print(x);
    }
    */
    
}

    public static String AddZero(int MsgLength,int Bit) {
            String Zeros="";
            int AddedZero=Bit-MsgLength;
            for(int i=0;i<AddedZero;i++){
            Zeros+="0";
            }     
            return Zeros;
    }
    
}


    
    
  /*  
   int IntTemp=Integer.decode("0x"+Temp); //Convert HEX String to decimal
    System.out.println("");
    
    int WI[] = new int[80];
    int i=0;
    for(String x:W){ 
    int decimal = Integer.decode("0x"+x);
    WI[i]=decimal;
    System.out.print(decimal + ",");
    i++;
    }
    
    System.out.println("");
    
   
    WI[16]=WI[0]^WI[2]^WI[8]^WI[13];
  
    System.out.println(Integer.toBinaryString(WI[16] << 1));
      */