package optional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Caso1 {
    class User{

        public Address getAddress() {
            return null;
        }
    }

    class Address{

        public Country getCountry() {
            return null;
        }
    }
    class Country{

        public String getIsocode() {
            return null;
        }
    }

    private void getIsoCode2( User user){
       //da exception
        Optional.of(user)
                .ifPresent(u->Optional.of(u.getAddress())
                    .ifPresent(a->Optional.of(a.getCountry())
                        .ifPresent(c->Optional.of(c.getIsocode())
                            .ifPresent(i->i.toUpperCase()))));

        Optional.ofNullable(user)
                .ifPresent(u->Optional.ofNullable(u.getAddress())
                    .ifPresent(a->Optional.ofNullable(a.getCountry())
                        .ifPresent(c->Optional.ofNullable(c.getIsocode())
                            .ifPresent(i->i.toUpperCase()))));

        //Optional.empty()==Optional.empty();

       User i= Optional.ofNullable(user).orElse(new User());

        find("u").ifPresent(u-> System.out.println("User"+user.getAddress()));

        Address a = find("z").map(User::getAddress).orElseGet(this::create);

        User userToRegister = find("u").orElse(new User());
    }

    private Address create(User u){
        //logica para la creacion de un  addres
        return new Address();
    }

    private Address create(){
        return new Address();
    }
    private Address normalize(Address r){
        return new Address();
    }

    private Optional<User> find(String id){
        return users().stream().findFirst();
    }

    private User findOrCreate(String id){
        return users().stream().findFirst().orElse(new User());
    }
    private void otrocaso(String id){
         users().stream().findFirst().ifPresentOrElse(t-> System.out.println(t), ()-> System.out.println("not found"));
    }

    private void getIsoCode( User user){
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                Country country = address.getCountry();
                if (country != null) {
                    String isocode = country.getIsocode();
                    if (isocode != null) {
                        isocode = isocode.toUpperCase();
                    }
                }
            }
        }
    }

    List<User> users(){
        return Collections.emptyList();
    }

}
