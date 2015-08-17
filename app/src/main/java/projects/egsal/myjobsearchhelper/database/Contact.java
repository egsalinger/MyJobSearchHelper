package projects.egsal.myjobsearchhelper.database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "Contacts")
public class Contact extends Model {
    @Column(name = "remote_id", unique = true)
    public long personId;

    @Column(name = "Name")
    public String name;

    @Column(name = "Mail")
    public String email;

    @Column(name = "Phone")
    public String phone;

    @Column(name = "Company", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Opportunity associatedWith;

    public Contact(int personId, String name, String email, String phone, Opportunity associatedWith) {
        super();
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.associatedWith = associatedWith;
    }

    public Contact() {
        super();
    }

    public static List<Contact> getAll(Contact contact) {
        // This is how you execute a query
        return new Select()
                .from(Contact.class)
                .where("associatedWith= ?", contact.getId())
                .orderBy("Name ASC")
                .execute();

    }
}