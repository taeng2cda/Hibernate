package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories", catalog = "blog_servlet")
@DynamicUpdate
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c ORDER BY c.name"),
        @NamedQuery(name = "Category.countAll", query = "SELECT COUNT(*) FROM Category"),
})
@Setter
@ToString
public class Category {
    private Integer categoryId;
    private String name;

    public Category () {
        super();
    }

    @Builder
    public Category(Integer categoryId, String name) {
        super();
        this.categoryId = categoryId;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true, nullable = false)
    public Integer getCategoryId() {
        return this.categoryId;
    }

    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return this.name;
    }
}
