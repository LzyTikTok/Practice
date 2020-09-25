package CrazyJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

class ReadThread extends Thread {
    private PipedReader pr;
    //用于包装管道流的BufferReader对象
    private BufferedReader br;

    public ReadThread(PipedReader pr) {
        this.pr = pr;
        this.br = new BufferedReader(pr);
    }

    @Override
    public void run() {
        String buf = null;
        try {
            //逐行读取管道输入流中的内容
            while ((buf = br.readLine()) != null) {
                System.out.println(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class WriterThread extends Thread {
    String[] books = new String[]{
            "Struts2权威指南",
            "基于J2EE的Ajax宝典",
            "轻量级J2EE企业应用指南"
    };
    private PipedWriter pw;

    public WriterThread() {
    }

    public WriterThread(PipedWriter pw) {
        this.pw = pw;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                pw.write(books[i % 4] + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

public class PipedCommunicationTest {
    public static void main(String[] args) {
        try (PipedWriter pw = new PipedWriter();
             PipedReader pr = new PipedReader()) {
            //连接
            pw.connect(pr);
            //将连接好的管道流分别传入两个线程，
            //就可以让两个线程通过管道流进行通信
            new WriterThread(pw).start();
            new ReadThread(pr).start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}