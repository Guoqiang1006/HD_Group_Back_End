package com.example.project;

import com.example.project.entity.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.project.controller.App_Controller.*;

public class load_data {
        public load_data() throws ParseException, IOException {
            /*
            Address address=new Address("-34.42463749447153","150.8928590557678","W125/200","Crown St","Wollongong","NSW2500",90.00,100.00);
            ClientAccount client=new ClientAccount("c1","Rick","Abc1234567",parseDate("1999-05-17 00:00:00"),"Male","0493417283","chenguoqiangsg@gmail.com");
            client.addAddress(address);

            addresses.put(address.getId(),address);
            clients.put(client.getClient_id(), client);
            */
            readClients();
            readProviders();
            readAddresses();
            readVouchers();
            readWallets();
        }

        private void readClients() throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/clients.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|\\|");
                ClientAccount client = new ClientAccount(parts[0],parts[1],parts[3],parseDate(parts[4]),parts[5],parts[6],parts[7],parts[8]);
                clients.put(client.getClient_id(), client);
            }
        }

        private void readProviders() throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/providers.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|\\|");
                ProviderAccount provider = new ProviderAccount(parts[0],parts[1],parts[3],parseDate(parts[4]),parts[5],parts[6],parts[7],parts[8],Boolean.parseBoolean(parts[9]),Boolean.parseBoolean(parts[10]),Boolean.parseBoolean(parts[11]),Boolean.parseBoolean(parts[12]),Boolean.parseBoolean(parts[13]),Boolean.parseBoolean(parts[14]));
                providers.put(provider.getProvider_id(), provider);
            }
        }

        private void readAddresses() throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/addresses.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|\\|");
                Address address=new Address(parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],Double.parseDouble(parts[8]),Double.parseDouble(parts[9]));
                if(parts[0].charAt(0) == 'c'){
                    ClientAccount client=clients.get(parts[0]);
                    addresses.put(address.getId(),address);
                    client.addAddress(address);
                }
                else{
                    ProviderAccount provider=providers.get(parts[0]);
                    addresses.put(address.getId(),address);
                    provider.addAddress(address);
                }
            }
        }

        private void readVouchers() throws IOException, ParseException {
                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/vouchers.txt"));
                String line;
                while ((line = reader.readLine()) != null){
                    String[] parts = line.split("\\|\\|");
                    Voucher voucher = new Voucher(parts[0],parts[1],parts[2],parts[3],Double.parseDouble(parts[4]),parts[5] );
                    vouchers.put(voucher.getVoucher_id(), voucher);
                }
        }

        private void readWallets() throws IOException {
                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/wallets.txt"));
                String line;
                while ((line = reader.readLine()) != null){
                    String[] parts = line.split("\\|\\|");
                    if (parts[0].charAt(0) == 'c'){
                        ClientAccount client=clients.get(parts[0]);
                        Wallet wallet = new Wallet(parts[0],parts[1],Double.parseDouble(parts[2]));
                        client.setWallet(wallet);
                        wallets.put(parts[0],wallet);
                    }
                    else{
                        ProviderAccount provider=providers.get(parts[0]);
                        Wallet wallet = new Wallet(parts[0],parts[1],Double.parseDouble(parts[2]));
                        provider.setWallet(wallet);
                        wallets.put(parts[0],wallet);
                    }
                }
        }

        private Date parseDate(String str) throws ParseException {
            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd");
            isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return isoFormat.parse(str);
        }


}
