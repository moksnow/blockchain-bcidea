package com.mok.blockchain.ui;

import com.mok.blockchain.Block;
import com.mok.blockchain.Blockchain;

import java.util.List;

public class MainMenu {
    public static void showMainMenu() {
        // Local variable
        int swValue;

        // Display menu graphics
        System.out.println("=============================================");
        System.out.println("|         BlockChain BCIDEA                  |");
        System.out.println("=============================================");
        System.out.println("| Options:                                   |");
        System.out.println("|             1. Add New Block               |");
        System.out.println("|             2. Validate Block Chain        |");
        System.out.println("|             3. Exit                        |");
        System.out.println("=============================================");
        swValue = Keyin.inInt(" Select option: ");

        // Switch construct
        switch (swValue) {
            case 1:
                System.out.println("Option 1 selected");
                String blockData = Keyin.inString("Enter Block Data: ");
                List<Block> blockList = Blockchain.addNewBlock(blockData);
                System.out.println("blockchain size is: " + blockList.size());
                System.out.println("new block data: " + blockData);
                System.out.println("new block hash: " + blockList.get(blockList.size() - 1).getHash());
                showMainMenu();
                break;
            case 2:
                boolean b = Blockchain.validateBlockchain();
                System.out.println("Blockchain is valid: " + b);
                showMainMenu();
                break;
            case 3:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Invalid selection");
                break; // This break is not really necessary
        }
    }
}
