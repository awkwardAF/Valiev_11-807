
public class Main {

    public static void main(String[] args) {

        PlayList p = new PlayList(3);

        AudioTrack a1 = new AudioTrack(123, "fnrjhfn", "jkfnje" );
        AudioTrack a2 = new AudioTrack(234, "mv", "jvnf");
        AudioTrack a3 = new AudioTrack( 45, "kj f", "vk lv");


        p.add(a1);
        p.add(a2);
        p.add(a3);

        p.show();
    }
}
