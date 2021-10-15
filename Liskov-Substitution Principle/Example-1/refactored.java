/*
The code can be corrected in many ways. First we can follow code by contract
principle. Extract common methods to an interface. Second we can make the
exception types similar, so similar types of exceptions are thrown if abstractions
are replaced by their implementations.
 */

public class refactored {
    public static void main(String[] args) {
        functionfoo(new AviVideoPlayer());
    }

    //A dummy function to illustrate behaviour.
    private static void functionfoo(VideoPlayer player) {
        /*
        Now we can remove all this type checking and simply
        catch for RuntimeException because for abstraction or
        its implementation only RuntimeException will be thrown.
        So we don't have to change code based on sub-or-super
        type
         */
        try {
            player.playVideo("FILE");
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

class VideoPlayer {
    public void playVideo(String file) {

        if (file != null) {
        /*
        Business logic to play the video file
         */
        } else {
            throw new RuntimeException();
        }
    }
}

class AviVideoPlayer extends VideoPlayer {
    @Override
    public void playVideo(String file) {
        /*
        In this case for example we check for specific
        file extension. The file to be playable by AviPlayer
        should end with .avi
         */

        // FIXME: 10/13/2021
//        if (file.extension == 'avi' && file != null) {
//            /*
//            Play The video to the user as doing above.
//             */
//        } else {
//            throw new RuntimeException();
//        }
    }
}
