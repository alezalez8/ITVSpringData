package itvdn.todolist.domain;


/*import lombok.Getter;
import lombok.Setter;*/

import javax.persistence.*;

@Entity
@Table(name = "MY_TABLE")
/*@Getter
@Setter*/
public class MyOwnTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME", nullable = false)
    String name;


    @Column(name = "AGE", nullable = false)
    int age;


    @OneToOne
    private User user;



}
