/*
 * This program reads the input.txt file and uses a recursive function to calculate and output
 * the list of steps needed to move all of the disks in the from peg 1 to peg 3 
 * in the Tower of Hanoi puzzle.
 *
 * By Zefeng Wang
 * Created on January 24, 2022*
*/

// import classes
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// class TowersOfHanoi
class TowersOfHanoi {

  public static void main(String[] args) throws IOException {
    
    // Reads each line of the file
    int line = 1;
    List<String> lines = Files.readAllLines(Paths.get("input.txt"),
                               StandardCharsets.UTF_8);
    Iterator<String> itr = lines.iterator();

    // Outputs the all of steps needed to beat the Tower of Hanoi and outputs error messages
    if (lines.size() != 0) {
      for (int i = 0; itr.hasNext(); i++) {
        System.out.println("Output for Line " + line);
        try {
          int num = Integer.parseInt(itr.next());
          if (num >= 0) {
            hanoi(num, 1, 3);
          } else {
            System.out.println("Please enter a positive integer");
          }
        } catch (Exception e) {
          System.out.println("Please enter an integer");
        }
        line++;
      }
    } else {
      System.out.println("Please enter at least one number");
    }
  }

  // Outputs the steps required to move num disks from 
  // the start ped to the end peg
  private static void hanoi(int num, int start, int end) {
    if (num == 1) {
      System.out.println("Move disk from peg " + start + " to peg " + end);
    } else {
      hanoi(num - 1, start, 6 - (start + end));
      System.out.println("Move disk from peg " + start + " to peg " + end);
      hanoi(num - 1, 6 - (start + end), end);
    }
  }
} 
