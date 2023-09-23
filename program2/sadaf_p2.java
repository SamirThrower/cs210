import java.io.*;
import java.util.ArrayList;

public class sadaf_p2 {
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
            FileInputStream input = new FileInputStream(inputFilename);
            BufferedInputStream buffIn = new BufferedInputStream(input);

            FileWriter fileWrit = new FileWriter(outputFilename);
            BufferedWriter buffwrite = new BufferedWriter(fileWrit);
            PrintWriter writes = new PrintWriter(buffwrite);
            byte[] bytes = new byte[1];

            while (buffIn.read(bytes) > 0) {
                String str = new String(bytes);
                writes.print(str);
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

            FileOutputStream out = new FileOutputStream(outputFilename);
            DataOutputStream output = new DataOutputStream(out);

            String inn;
            //byte[] bytes;
            while((inn = input.readLine()) != null) {
                inputLines.add(inn);
                byte[] bytes = inn.getBytes();

                output.write(bytes);
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
