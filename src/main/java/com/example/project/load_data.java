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
            readPayments();
            readMemberships();
            readOrders();

            readReviews();
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


    private void readAddresses() throws IOException {
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

        private void readVouchers() throws IOException {
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

        public void readPayments() throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/payments.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split("\\|\\|");
                Payment payment =new Payment(parts[0],parts[1],Double.parseDouble(parts[2]),parseDate(parts[3]));
                payments.put(parts[0],payment);
            }
        }

        public void readMemberships() throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/members.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split("\\|\\|");
                if (parts[0].charAt(0) == 'c'){
                    ClientAccount client=clients.get(parts[0]);
                    Membership membership = new Membership(parts[0],parts[1],parts[2],parseDate(parts[3]),Double.parseDouble(parts[4]),parts[5],parts[6]);
                    client.setMembership(membership);
                    memberships.put(parts[1],membership);
                }
                else{
                    ProviderAccount provider=providers.get(parts[0]);
                    Membership membership = new Membership(parts[0],parts[1],parts[2],parseDate(parts[3]),Double.parseDouble(parts[4]),parts[5],parts[6]);
                    provider.setMembership(membership);
                    memberships.put(parts[1],membership);
                }
            }
        }
        public void readOrders() throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/orders.txt"));
            String line;
            while ((line = reader.readLine())!=null){
                String[] parts = line.split("\\|\\|");
                Order order;
                if(parts[11].charAt(0)=='p'){
                    order = new Order(parts[0],parts[1],clients.get(parts[2]),providers.get(parts[3]),addresses.get(parts[4]),Integer.parseInt(parts[5]),parseDate(parts[6]),parseDate(parts[7]),parseDate(parts[8]),parseDate(parts[9]),Double.parseDouble(parts[10]),payments.get(parts[11]),vouchers.get(parts[12]),parts[13]);
                }else {
                    order = new Order(parts[0], parts[1], clients.get(parts[2]), providers.get(parts[3]), addresses.get(parts[4]), Integer.parseInt(parts[5]), parseDate(parts[6]), parseDate(parts[7]), parseDate(parts[8]), parseDate(parts[9]), Double.parseDouble(parts[10]), memberships.get(parts[11]), vouchers.get(parts[12]), parts[13]);
                }
                orders.put(parts[0],order);
            }
        }

        public void readReviews() throws IOException, ParseException {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/reviews.txt"));
            String line;
            while ((line = reader.readLine())!=null){
                String[] parts = line.split("\\|\\|");
                Review review = new Review(Integer.parseInt(parts[1]),parts[2],parseDate(parts[3]));
                for(Order order:orders.values()){
                    if(order.getOrder_id().equals(parts[0])){
                        order.getProvider().addReview(parts[0],review);
                    }
                }
            }
        }

        private Date parseDate(String str) throws ParseException {
            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd");
            isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return isoFormat.parse(str);
        }


}
