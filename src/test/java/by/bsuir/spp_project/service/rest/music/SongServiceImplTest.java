package by.bsuir.spp_project.service.rest.music;

import by.bsuir.spp_project.entity.music.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongServiceImplTest {
    //todo for tests
    //1. db activity for init
    //2. db activity for destroy
    //3. service for crud


    @Test
    void create() {
    }

    @Test
    void readAll() {
    }

    @Test
    void readById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void taoString() {
        Song song = new Song(0, "Fire", "OlegSidor", 3.45, 2.5);
        System.out.print(song.toString());
    }
}