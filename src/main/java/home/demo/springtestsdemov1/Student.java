package home.demo.springtestsdemov1;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean active;
    private int grade;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id")
    @ToString.Exclude
    private ClassRoom classRoom;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
