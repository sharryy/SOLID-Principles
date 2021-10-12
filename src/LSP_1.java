/*
If we look at this piece of Code, the point where Liskov Substitution
principle is broken is where we introduce different exception in Child
Class. Now we have to separately check if a class is instanceof some
particular type, then handle this exception otherwise handle other exception.
If any other video player is added then we have to add another type-checking.
breaking Open-Closed Principle.
Whenever code breaks LSP, it also breaks OCP (Open-Closed) Principle.
Similarly, the pre-conditions are not matching as well. This is clear
violation of LSP.
 */

public class LSP_1 {
    public static void main(String[] args) {
        functionfoo(new AviVideoPlayer());
    }

    //A dummy function to illustrate behaviour.
    private static void functionfoo(VideoPlayer player) {
        if (player instanceof AviVideoPlayer) {
            try {
                //Do Something -- Overriding Parent Method
                player.playVideo("file");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else if (player instanceof VideoPlayer) {
            try {
                //Do Something
                player.playVideo("File");
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
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
            throw new NullPointerException(); // <------- THIS IS WHERE PROBLEM BEGINS.
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
        if (file.extension == 'avi') {
            /*
            Play The video to the user as doing above.
             */
        } else {
            throw new IllegalArgumentException("Invalid File Extension"); //  <--------- THIS IS PROBLEMATIC CODE.
        }
    }
}