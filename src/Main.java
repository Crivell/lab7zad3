import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random random = new Random();
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        double m = Double.parseDouble(args[1]);
        double σ = Double.parseDouble(args[2]);
        assert σ >= 0 : "ERROR: σ musi byc dodatnie";
        List<Double> array = new ArrayList<Double>();
        try{
            DataOutputStream out = new DataOutputStream(new FileOutputStream("bin.bin"));
            DataInputStream in = new DataInputStream(new FileInputStream("bin.bin"));
            DataOutputStream outxt = new DataOutputStream(new FileOutputStream("txt.txt"));
            for(int i = 0;i < n;i++){
                double d  = nextGaussian(m,σ);
                System.out.println(d);
                out.writeDouble(d);
            }
            System.out.println();
            for(int i=0;i<n;i++){
                outxt.writeBytes(String.valueOf(in.readDouble()).replace('.',',')+'\n');
            }
        }catch (FileNotFoundException x){
            System.out.println(x.getMessage());
        }catch (IOException x){
            System.out.println(x.getMessage());
        }
    }

    public static double nextGaussian(double m, double σ){

        return random.nextGaussian()* σ + m;
    }
}
