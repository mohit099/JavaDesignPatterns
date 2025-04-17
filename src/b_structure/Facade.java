package b_structure;

class TV1 {
    void turnOn() { System.out.println("TV turned ON"); }
    void turnOff() { System.out.println("TV turned OFF"); }
}

class SoundSystem {
    void turnOn() { System.out.println("Sound System turned ON"); }
    void turnOff() { System.out.println("Sound System turned OFF"); }
    void setVolume(int level) { System.out.println("Volume set to " + level); }
}

class DvdPlayer {
    void turnOn() { System.out.println("DVD Player turned ON"); }
    void turnOff() { System.out.println("DVD Player turned OFF"); }
    void playMovie(String movie) { System.out.println("Playing movie: " + movie); }
}

class Light {
    void dim() { System.out.println("Lights dimmed for movie mode"); }
    void brighten() { System.out.println("Lights brightened"); }
}

class HomeTheater {

    TV1 tv;
    DvdPlayer dvdPlayer;
    SoundSystem soundSystem;
    Light light;

    HomeTheater(TV1 tv, DvdPlayer dvdPlayer, SoundSystem soundSystem, Light light){
        this.tv = tv;
        this.dvdPlayer = dvdPlayer;
        this.soundSystem = soundSystem;
        this.light = light;
    }

    public void watchMovie(String movieName){
        System.out.println("\nPreparing Home Theater for movie...");
        tv.turnOn();
        soundSystem.turnOn();
        soundSystem.setVolume(20);
        dvdPlayer.turnOn();
        light.dim();
        dvdPlayer.playMovie(movieName);
    }

    public void stopMovie(){
        System.out.println("\nShutting down Home Theater...");
        dvdPlayer.turnOff();
        soundSystem.turnOff();
        light.brighten();
        tv.turnOff();
    }
}


public class Facade {

    public static void main(String[] args) {


        TV1 tv1 = new TV1();
        SoundSystem soundSystem = new SoundSystem();
        DvdPlayer dvdPlayer = new DvdPlayer();
        Light light = new Light();

        HomeTheater homeTheater = new HomeTheater(tv1,dvdPlayer,soundSystem,light);

        homeTheater.watchMovie("Tiger Zinda hai");
        homeTheater.stopMovie();
    }
}
