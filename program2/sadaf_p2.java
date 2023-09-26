import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sadaf_p2{
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Pass 3 commandline arguments!");
            System.exit(0);
        }
		if (!(args[0].startsWith("b") || args[0].startsWith("t"))) {
			System.out.println("First commandline argument must start with b or t!");
            System.exit(0);
        }
		else {
			if (args[0].startsWith("b"))
				convertBinaryToText(args[1], args[2]);
			else
				convertTextToBinary(args[1], args[2]);
		
		}
	}
	
	private static void convertBinaryToText(String inputFilename, String outputFilename) {
		System.out.println("convertBinaryToText");
		try
		{
            // put your code to read a binary file and output it as a text file
            DataInputStream input = new DataInputStream(new FileInputStream(inputFilename));

            FileWriter fileWrit = new FileWriter(outputFilename);
            BufferedWriter buffwrite = new BufferedWriter(fileWrit);
            PrintWriter writes = new PrintWriter(buffwrite);

			int blockNum = input.readInt();

            for (int i = 0; i < blockNum; i++) {
				if (input.readChar() == 'i') 
					writes.write(input.readInt());
				if (input.readChar() == 'l')
					writes.write("" + input.readLong());
				if (input.readChar() == 'h')
					writes.write("" + input.readShort());
				if (input.readChar() == 'f')
					writes.write("" + input.readFloat());
				if (input.readChar() == 'd')
					writes.write("" + input.readDouble());
				if (input.readChar() == 'h')
					writes.write("" + input.readShort());
				if (input.readChar() == 'b') {
					int len = input.readInt();
					for (int j = 0; i < len; i++) {
						writes.write("" + input.readLong());
					}
				}
				if (input.readChar() == 's') {
					int len = input.readInt();
					for (int j = 0; i < len; i++) {
						writes.write(input.readChar());
					}
				}
				if (input.readChar() == 'g') {
					int len = input.readInt();
					for (int j = 0; i < len; i++) {
						writes.write("" + input.readFloat());
					}
				}
			}
            
            input.close();
            writes.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}

    private static void convertTextToBinary(String inputFilename, String outputFilename)
	{
		System.out.println("convertTextToBinary");
		try
		{
			// put your code to read a text file and output it as a binary file
            ArrayList<String> inputLines = new ArrayList<>(0);

            FileInputStream file = new FileInputStream(inputFilename);
            InputStreamReader reader = new InputStreamReader(file);
            BufferedReader input = new BufferedReader(reader);

            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFilename));

            String inn;

            byte[] conversion = new byte[8];
			ByteBuffer buffByte = ByteBuffer.wrap(conversion);

            while((inn = input.readLine()) != null) {
				if (inn.length() == 0 || inn.charAt(0) == '#')
					continue;

				inputLines.add(inn);
				StringTokenizer token = new StringTokenizer(inn, "	");

				switch (token.nextToken()) {
					case "string":
						buffByte.putChar('s');
						char[] charArray = token.nextToken().toCharArray();
						int stringLen = charArray.length;
						buffByte.putInt(stringLen);
						for (int i = 0; i < stringLen; i ++) {
							buffByte.putChar(charArray[i]);
							buffByte.get(conversion);
							output.write(conversion);
						}
						break;
					case "double":
						buffByte.putChar(0,'d');
						output.write(conversion);
						double convDouble = Double.parseDouble(token.nextToken());
						buffByte.putDouble(convDouble);
						output.write(conversion);
						break;
					case "int":
						buffByte.putChar(0,'i');
						int convInt = Integer.parseInt(token.nextToken());
						buffByte.putInt(2, convInt);
						buffByte.get(conversion);
						output.write(conversion);
						break;
					case "float":
						buffByte.putChar(0, 'f');
						float convFloat = Float.parseFloat(token.nextToken());
						buffByte.putFloat(2, convFloat);
						buffByte.get(conversion);
						output.write(conversion);
						break;
					case "long":
						buffByte.putChar(0, 'l');
						long convLong = Long.parseLong(token.nextToken());
						buffByte.putLong(2, convLong);
						buffByte.get(conversion);
						output.write(conversion);
						break;
					case "short":
						buffByte.putChar(0, 'h');
						short convShort = Short.parseShort(token.nextToken());
						buffByte.putShort(2, convShort);
						buffByte.get(conversion);
						output.write(conversion);
						break;
					case "long array":
						buffByte.putChar('b');
						StringTokenizer longArr = new StringTokenizer(token.nextToken(), ",");
						int longLen = longArr.countTokens();
						buffByte.putInt(longLen);
						for (int i = 0; i < longLen; i++) {
							buffByte.putLong(Long.parseLong(longArr.nextToken()));
							buffByte.get(conversion);
							output.write(conversion);
						}
						break;
					case "float array":
						
						buffByte.putChar('g');
						StringTokenizer floatArr = new StringTokenizer(token.nextToken(), ",");
						int floatLen = floatArr.countTokens();
						buffByte.putInt(floatLen);
						for (int i = 0; i < floatLen; i++) {
							buffByte.putFloat(Float.parseFloat(floatArr.nextToken()));
							buffByte.get(conversion);
							output.write(conversion);
						}
						break;
				}
                output.write(System.lineSeparator().getBytes());
            }
			
            input.close();
            output.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
