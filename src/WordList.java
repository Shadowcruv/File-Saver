/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 9 Sample Development: Word Concordance

    File: WordList.java

*/


/**
 *   class WordList (Helper Class)
 *
 *   The helper class for Ch9WordConcordance program. This
 *   class maintains the word list.
 *
 * @author Dr. Caffeine
 */

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class WordList {

//----------------------------------
//    Data Members
//----------------------------------
    /** Sorted hash map for maintaining the word list */
    SortedMap table;

//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public WordList( ) {
        table = new TreeMap();
    }

//----------------------------------
//    Public Methods
//
//          void   add              ( String    )
//          String getConcordance   (           )
//
//----------------------------------

    /**
     * Adds a new entry to the word list
     *
     * @param word word to add to the list
     */
    public void add(String word) {
        Integer val;

        if (table.containsKey(word)) {
            val = (Integer) table.get(word);
            val = new Integer(val.intValue()+1);

        } else { //word occurs for the first time
            val = new Integer(1);
        }

        table.put(word, val);
    }

    /**
     * Returns the word concordance as a String
     *
     * @return the word concordance as a String
     */
    public String getConcordance( ) {
        String line;
        String lineTerminator = System.getProperties().getProperty("line.separator");

        StringBuffer strBuf = new StringBuffer("");

        Map.Entry entry;
        DecimalFormat df = new DecimalFormat("0000");

        Iterator itr = table.entrySet().iterator();

        while (itr.hasNext()) {
            entry = (Map.Entry) itr.next();
            line  =  entry.getValue().toString() + "\t" +
                    entry.getKey() +
                    lineTerminator;

            strBuf.append(line);
        }

        return strBuf.toString();
    }

    /**
     * Clears all entry from the map
     */
    public void reset( ) {
        table.clear();
    }

}

