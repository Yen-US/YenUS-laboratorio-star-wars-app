import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void HelloWorld() {
        System.out.println("Hola Mundo,Hello World: inglish");
    }
    public static void JTableDisplay() throws IOException {
            JFrame frame = new JFrame("Star Wars Info");

            JPanel panel = new JPanel();

            ApiReq Request= new ApiReq();
            List<Character> Res = Request.Req().getResults();
            panel.setLayout(new BorderLayout());
            String data[][]=new String[Res.size()][3];
            for (int i = 0; i<Res.size();i++){
                data[i][0]= Res.get(i).getName();
                data[i][1]= String.valueOf(Res.get(i).getHeight());
                data[i][2]= Res.get(i).getBirth_year();
            }

            String column[]={"Nombre","Altura","Fecha de Nacimiento"};


            JTable table = new JTable(data,column);


            JScrollPane tableContainer = new JScrollPane(table);

            panel.add(tableContainer, BorderLayout.CENTER);
            frame.getContentPane().add(panel);

            frame.pack();
            frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        HelloWorld();
        JTableDisplay();

    }
}
