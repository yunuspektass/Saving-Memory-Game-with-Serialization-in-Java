import java.io.*;

public class OyunKayıt {
    public static void oyunKaydet(Kart[][] kartlar){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("kayit.bin"))) {
            System.out.println("Oyun Kaydediliyor.");

            out.writeObject(kartlar);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Kart[][] kayıttanAl(){

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("kayit.bin"))) {

            Kart[][] cikti = (Kart[][]) in.readObject();

            return cikti;

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
