/*
A help program that uses a disk file to store help information.
 */

import java.io.*;

/*
The Help class opens a help file, searches for a topic, and then displays the information
associated with that topic.
Notice that it handles all I/O exceptions itself, avoiding the need for the calling code
to do so.
 */

class Help {
    String helpfile;  // name of help file

    Help (String fname) {
        helpfile = fname;
    }

    // Display help on a topic.
//    The helpOn( ) method works like this. A string containing the name of the topic
//    is passed in the what parameter. The help file is then opened. Then, the file is
//    searched, looking for a match between what and a topic in the file. Remember,
//    in the file, each topic is preceded by a #, so the search loop scans the file for #s.
//    When it finds one, it then checks to see if the topic following that # matches the
//    one passed in what. If it does, the information associated with that topic is
//    displayed. If a match is found, helpOn( ) returns true. Otherwise, it returns
//    false.
    boolean helpOn (String what) {
        int ch;
        String topic, info;

        // Open the help file.
//        The help file is opened using a FileReader that is wrapped in a
//        BufferedReader. Since the help file contains text, using a character
//        stream allows the Help system to be more efficiently internationalized.
        try (BufferedReader helpRdr =
                new BufferedReader(new FileReader(helpfile))) {
            do {
                // read characters until a # is found
                ch = helpRdr.read();

                // now, see if topics match
                if (ch == '#') {
                    topic = helpRdr.readLine();
                    if (what.compareTo(topic) == 0) {  // found topic
                        do {
                            info = helpRdr.readLine();
                            if (info != null) System.out.println(info);
                        } while ((info != null) && (info.compareTo("") != 0));
                        return true;
                    }
                }
            } while (ch != -1);
        } catch (IOException e) { // By handling its own exceptions, it
            // prevents this burden from being passed on to all code that uses it.
            System.out.println("Error accessing help file.");
            return false;
        }
        return false; // topic not found
    }

    // Get a Help topic.
//    This method creates a BufferedReader attached to System.in. It then prompts
//    for the name of a topic, reads the topic, and returns it to the caller.
    String getSelection() {
        String topic = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter topic: ");
        try {
            topic = br.readLine();
        } catch (IOException exc) {
            System.out.println("Error reading console.");
        }
        return topic;
    }
}

// Demonstrate the file-based Help system.
class FileHelp {
    public static void main(String[] args) {
        Help hlpobj = new Help("helpfile.txt");
        String topic;

        System.out.println("Try the help system. Enter 'stop' to end.");
        do {
            topic = hlpobj.getSelection();

            if (!hlpobj.helpOn(topic))
                System.out.println("Topic not found.\n");
        } while (topic.compareTo("stop") != 0);
    }
}