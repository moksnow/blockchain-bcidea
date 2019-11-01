package com.mok.blockchain;

import com.mok.blockchain.ui.MainMenu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {

    private static List<Block> blockchain = new ArrayList<Block>();
    private static int prefix = 4;
    private static String prefixString = new String(new char[prefix]).replace('\0', '0');

    static {
        Block genesisBlock = new Block("The is the Genesis Block.", "0", new Date().getTime());
        genesisBlock.mineBlock(prefix);
        blockchain.add(genesisBlock);
        Block firstBlock = new Block("The is the First Block.", genesisBlock.getHash(), new Date().getTime());
        firstBlock.mineBlock(prefix);
        blockchain.add(firstBlock);
    }

    public static List<Block> addNewBlock(String data) {
        Block newBlock = new Block(data, blockchain.get(blockchain.size() - 1)
                .getHash(), new Date().getTime());
        newBlock.mineBlock(prefix);
        if (newBlock.getHash()
                .substring(0, prefix)
                .equals(prefixString))
            blockchain.add(newBlock);
        return blockchain;
    }

    public static boolean validateBlockchain(){
        boolean flag = true;
        for (int i = 0; i < blockchain.size(); i++) {
            String previousHash = i==0 ? "0" : blockchain.get(i - 1).getHash();
            flag = blockchain.get(i).getHash().equals(blockchain.get(i).calculateBlockHash())
                    && previousHash.equals(blockchain.get(i).getPreviousHash())
                    && blockchain.get(i).getHash().substring(0, prefix).equals(prefixString);
            if (!flag) break;
        }
        return flag;
    }

    public static void main(String[] args) {
        MainMenu.showMainMenu();
    }
}
