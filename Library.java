
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class Library {

    private static List<People> getSpaceData() throws Exception {
        URL url = new URL("https://smartlogic.io/apprentice/code-test/space.txt");
        HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
        httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
        InputStream is = httpcon.getInputStream();
        Scanner s = new Scanner(is).useDelimiter("\\A");
        String string = s.hasNext() ? s.next() : "";
        String[] array = string.split("\\n");

        List<People> peopleList = new ArrayList<>();
        for (String element : array) {
            People person = peopleCreator(element, " ");
            peopleList.add(person);
        }

        return peopleList;
    }

    private static List<People> getCommaData() throws Exception {
        URL url = new URL("https://smartlogic.io/apprentice/code-test/comma.txt");
        HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
        httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
        InputStream is = httpcon.getInputStream();
        Scanner s = new Scanner(is).useDelimiter("\\A");
        String string = s.hasNext() ? s.next() : "";
        String[] array = string.split("\\n");

        List<People> peopleList = new ArrayList<>();
        for (String element : array) {
            People person = peopleCreator(element, ", ");
            peopleList.add(person);
        }

        return peopleList;
    }

    private static List<People> getPipeData() throws Exception {
        URL url = new URL("https://smartlogic.io/apprentice/code-test/pipe.txt");
        HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
        httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
        InputStream is = httpcon.getInputStream();
        Scanner s = new Scanner(is).useDelimiter("\\A");
        String string = s.hasNext() ? s.next() : "";
        String[] array = string.split("\\n");

        List<People> peopleList = new ArrayList<>();
        for (String element : array) {
            People person = peopleCreator(element, " \\| ");
            peopleList.add(person);
        }

        return peopleList;
    }

    private static People peopleCreator(String record, String delimeter) throws Exception {
        String[] array = record.split(delimeter);
        List<String> list = new ArrayList<>(Arrays.asList(array));
        if (" ".equals(delimeter)) {
            spaceFormatter(list);
        }
        if (", ".equals(delimeter)) {
            commaFormatter(list);
        }
        if (" \\| ".equals(delimeter)) {
            pipeFormatter(list);
        }
        People person = new People(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));

        return person;
    }

    private static List<String> spaceFormatter(List<String> list) throws Exception {
        list.remove(2);
        if ("M".equals(list.get(2))) {
            list.set(2, "Male");
        }
        if ("F".equals(list.get(2))) {
            list.set(2, "Female");
        }
        Date date1 = new SimpleDateFormat("M-d-yyyy").parse(list.get(3));
        String date2 = new SimpleDateFormat("M/d/yyyy").format(date1);
        list.set(3, date2);

        return list;
    }

    private static List<String> commaFormatter(List<String> list) throws Exception {
        Collections.swap(list, 3, 4);

        return list;
    }

    private static List<String> pipeFormatter(List<String> list) throws Exception {
        list.remove(2);
        if ("M".equals(list.get(2))) {
            list.set(2, "Male");
        }
        if ("F".equals(list.get(2))) {
            list.set(2, "Female");
        }
        Date date1 = new SimpleDateFormat("M-d-yyyy").parse(list.get(4));
        String date2 = new SimpleDateFormat("M/d/yyyy").format(date1);
        list.set(4, date2);
        Collections.swap(list, 3, 4);

        return list;
    }

    public static void outputGenerator() throws Exception {

        List<People> list = new ArrayList<>();
        list.addAll(getSpaceData());
        list.addAll(getCommaData());
        list.addAll(getPipeData());

        String output = "output.txt";
        try (PrintWriter outputStream = new PrintWriter(output)) {
            {
                Collections.sort(list, new LastNameComparator());
                Collections.sort(list, new GenderComparator());

                outputStream.println("Output 1: ");
                for (int i = 0; i < list.size(); i++) {
                    outputStream.printf("%s %s %s %s %s%n", list.get(i).getLastName(), list.get(i).getFirstName(), list.get(i).getGender(), list.get(i).getDateOfBirth(), list.get(i).getFavoriteColor());
                }
                outputStream.println();
            }
            {
                Collections.sort(list, new LastNameComparator());
                Collections.sort(list, new DateOfBirthComparator());
                outputStream.println("Output 2: ");
                for (int i = 0; i < list.size(); i++) {
                    outputStream.printf("%s %s %s %s %s%n", list.get(i).getLastName(), list.get(i).getFirstName(), list.get(i).getGender(), list.get(i).getDateOfBirth(), list.get(i).getFavoriteColor());
                }
                outputStream.println();
            }
            {
                Collections.sort(list, new LastNameComparator());
                Collections.reverse(list);

                outputStream.println("Output 3: ");
                for (int i = 0; i < list.size(); i++) {
                    outputStream.printf("%s %s %s %s %s%n", list.get(i).getLastName(), list.get(i).getFirstName(), list.get(i).getGender(), list.get(i).getDateOfBirth(), list.get(i).getFavoriteColor());
                }
            }
        }
        System.out.println("Done.");
    }
}
