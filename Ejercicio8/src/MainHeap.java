
import java.util.*;
import java.io.*;

public class MainHeap {

    static StringBuilder sb;
    static dsu dsu;
    static long fact[];
    static int mod = (int) (1e9 + 7);

    static void solveSave() {
        int queries = i();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<String> res = new ArrayList<>();
        while (queries-- > 0) {
            String s = s();
            if (s.equals("insert")) {
                int x = i();
                pq.add(x);
                res.add(s + " " + x);
            } else if (s.equals("getMin")) {
                int x = i();
                while (pq.size() > 0 && pq.peek() < x) {
                    pq.poll();
                    res.add("removeMin");
                }
                if (pq.size() == 0 || pq.peek() > x) {
                    pq.add(x);
                    res.add("insert " + x);
                }
                res.add("getMin " + x);
            } else {
                if (pq.size() == 0) {
                    pq.add(1);
                    res.add("insert 1");
                    res.add("removeMin");
                    pq.poll();
                } else {
                    pq.poll();
                    res.add("removeMin");
                }
            }
        }
        /*
        sb.append(res.size() + "\n");
        for (String s : res) {
            sb.append(s).append("\n");
        }
        */
        
        try {
            String ruta = "C:/Users/FREDDY/Desktop/prueba/result.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter fw = new PrintWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(String.valueOf(res.size()+" \n"));

            for (int i = 0; i < res.size(); i++) {
                if (i == res.size() - 1) {
                    bw.write(res.get(i) + " \n");
                } else {
                    bw.write(res.get(i) + " \n");
                }
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void solve() {
        int queries = i();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<String> res = new ArrayList<>();
        while (queries-- > 0) {
            String s = s();
            if (s.equals("insert")) {
                int x = i();
                pq.add(x);
                res.add(s + " " + x);
            } else if (s.equals("getMin")) {
                int x = i();
                while (pq.size() > 0 && pq.peek() < x) {
                    pq.poll();
                    res.add("removeMin");
                }
                if (pq.size() == 0 || pq.peek() > x) {
                    pq.add(x);
                    res.add("insert " + x);
                }
                res.add("getMin " + x);
            } else {
                if (pq.size() == 0) {
                    pq.add(1);
                    res.add("insert 1");
                    res.add("removeMin");
                    pq.poll();
                } else {
                    pq.poll();
                    res.add("removeMin");
                }
            }
        }
        sb.append(res.size() + "\n");
        for (String s : res) {
            sb.append(s).append("\n");
        }
    }
    

    public static void main(String[] args) {
        sb = new StringBuilder();
        int test = 1;
        while (test-- > 0) {
            solve();
        }
        System.out.println(sb);

    }

    /*
   * fact=new long[(int)1e6+10]; fact[0]=fact[1]=1; for(int i=2;i<fact.length;i++)
   * { fact[i]=((long)(i%mod)1L(long)(fact[i-1]%mod))%mod; }
     */
//**************NCR%P******************
//**************END******************
    // *************Disjoint set
    // union*********//
    static class dsu {

        int parent[];

        dsu(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = -1;
            }
        }

        int find(int a) {
            if (parent[a] < 0) {
                return a;
            } else {
                int x = find(parent[a]);
                parent[a] = x;
                return x;
            }
        }

        void merge(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) {
                return;
            }
            parent[b] = a;
        }
    }

//****CLASS PAIR **************************************************
    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int Int() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String String() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return String();
        }

        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {

        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);

    public static int i() {
        return in.Int();
    }

    public static long l() {
        String s = in.String();
        return Long.parseLong(s);
    }

    public static String s() {
        return in.String();
    }

    public static int[] readArrayi(int n) {
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i();
        }
        return A;
    }

    public static long[] readArray(long n) {
        long A[] = new long[(int) n];
        for (int i = 0; i < n; i++) {
            A[i] = l();
        }
        return A;
    }

}
