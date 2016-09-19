import java.util.UUID;

/**
 * Created by DennisThinhTan on 19-09-2016.
 */
public class Producer implements Runnable {

    private Buffer buffer;
    private UUID uuid;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
        uuid = UUID.randomUUID();

    }

    public void run() {
        //While unavailable keep trying
    }
}