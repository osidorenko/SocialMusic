package by.bsuir.spp_project.dao.music;

import by.bsuir.spp_project.entity.music.Gengre;
import by.bsuir.spp_project.entity.music.Song;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.InputStream;
import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SongDataPostgreSQLTest {
    /*@Test
    public void test() {
        int arr[] = new int[5];
        System.out.println(arr);
    }

    @Test
    public void test1() {
        int z = 0;
        int i = 0;
        for (; i < 1; i++) {
            long t1 = one();
            //System.out.println();
            long t2 = one1();
            //assert t1 > t2;
            if (t1 > t2) {
                z++;
            } else {
            }
        }
        System.out.println("new " + z + "\n" + "optimal " + (i - z));


    }

    public void merge1(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> list = new ArrayList<>();
        int size = a.size();
        int j = 0;
        int i = 0;
        while (i < size && j < size) {
            if (a.get(i) <= b.get(j)) {
                list.add(a.get(i++));
            } else {
                list.add(b.get(j++));
            }
        }
        if (j > i) {
            while (i < size) {
                list.add(a.get(i++));
            }
        } else {
            while (j < size) {
                list.add(b.get(j++));
            }
        }
        int x = 0;
        for (x = 0; x < size; x++) {
            a.set(x, list.get(x));
        }
        while (x < list.size()) {
            a.add(list.get(x++));
        }
        list.clear();
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> list = new ArrayList<>();
        int size = a.size();
        int j = 0;
        int i = 0;
        while (i < size && j < size) {
            if (a.get(i) <= b.get(j)) {
                list.add(a.get(i++));
            } else {
                list.add(b.get(j++));
            }
        }
        if (j > i) {
            while (i < size) {
                list.add(a.get(i++));
            }
        } else {
            while (j < size) {
                list.add(b.get(j++));
            }
        }
        a.removeAll(a);
        a.addAll(list);
        *//*int x = 0;
        for (x = 0; x < size; x++) {
            a.set(x, list.get(x));
        }
        while (x < list.size()) {
            a.add(list.get(x++));
        }*//*
        list.clear();
    }

    long three() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 5, 7, 9, 11, 21, 31, 120));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 7, 8, 10, 22, 22, 40, 100));
        long time = System.nanoTime();
        TreeMap<String, Integer> set = new TreeMap<>();
        Iterator<Integer> iterator = arr1.iterator();
        Iterator<Integer> iterator2 = arr2.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Integer i1 = iterator.next();
            Integer i2 = iterator2.next();
            set.put("" + (i++), i2);
            set.put("" + i++, i1);
        }
        long ret = System.nanoTime() - time;
        System.out.println(ret);
        set.forEach((a, b) -> System.out.print(" " + b));
        return ret;
    }

    @Test
    void ttt() {
        String[] s = new String[3];
        for (String l : s) {
            System.out.println(l);
        }

    }

    long two() {
        int i = 1;
        String[] s = new String[3];
        for (String l : s) {
            System.out.println(l);
        }

        if (i++ < 1) {
            System.out.println(i);
        } else {
            System.out.println(i);
        }
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 5, 7, 9, 11, 21, 31, 120));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 7, 8, 10, 22, 22, 40, 100));

        System.out.println();
        ArrayList<Integer> list = new ArrayList();
        long time = System.nanoTime();
        list.addAll(arr1);
        list.addAll(arr2);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        long ret = System.nanoTime() - time;
        System.out.println(ret);
        list.forEach(S -> System.out.print(" " + S));
        return ret;
    }

    long one() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 5, 7, 9, 11, 21, 31, 120));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 7, 8, 10, 22, 22, 40, 100));
        *//*arr1.forEach(s -> System.out.print(s + " "));
        System.out.println();
        arr2.forEach(s -> System.out.print(s + " "));
        System.out.println();*//*
        long time = System.nanoTime();
        merge(arr1, arr2);
        long ret = System.nanoTime() - time;
        *//*System.out.println(ret);
        arr1.forEach(s -> System.out.print(s + " "));
        System.out.println();
        arr2.forEach(s -> System.out.print(s + " "));
        System.out.println();*//*
        return ret;
    }


    long one1() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 5, 7, 9, 11, 21, 31, 120));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 7, 8, 10, 22, 22, 40, 100));
        *//*arr1.forEach(s -> System.out.print(s + " "));
        System.out.println();
        arr2.forEach(s -> System.out.print(s + " "));
        System.out.println();*//*
        long time = System.nanoTime();
        merge1(arr1, arr2);
        long ret = System.nanoTime() - time;
        *//*System.out.println(ret);
        arr1.forEach(s -> System.out.print(s + " "));
        System.out.println();
        arr2.forEach(s -> System.out.print(s + " "));
        System.out.println();*//*
        return ret;
    }

    void testApp() {

    }

    @Test
    void getByValue() {
        //String s = "path/oleg.png";
        //int size = s.length();
        //boolean l = s.substring(size - 3, size).equals("png");
        // System.out.println(l);
        Song song = new Song(1, "nothing and matters", "metallica", 5.6, 4.5, Gengre.ROCK.toString());
        System.out.println(song.hashCode());
    }
    //1003752023

    public void testiostraerm() {
        InputStream ios = null;


    }

    public static int getSum(int ar[][]) {
        int sum = 0;
        if (ar.length % 2 == 0) {
            int size = ar.length - 1;
            for (int i = 0; i < size + 1; i++) {
                sum += ar[i][i];
                sum += ar[i][size - i];
            }
        } else {
            int size = ar.length - 1;
            int s = size / 2;
            for (int i = 0; i < size + 1; i++) {
                if (i == s) {
                    sum += ar[i][i];
                } else {
                    sum += ar[i][i];
                    sum += ar[i][size - i];
                }
            }
        }

        return sum;
    }*/
}