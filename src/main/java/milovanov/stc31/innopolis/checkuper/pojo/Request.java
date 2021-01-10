package milovanov.stc31.innopolis.checkuper.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RequestStatus status;
    @Column(name = "dt_start")
    private Date intervalStartTime;
    @Column(name = "dt_end")
    private Date intervalEndTime;
    @Column(name = "dt_comleted")
    private Date completionTime;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "executor_id", referencedColumnName = "id")
    private Executor executor;
    @Column(name = "descr")
    private String descr;
    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY)
    private List<CheckList> checkLists;

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public Date getIntervalStartTime() {
        return intervalStartTime;
    }

    public void setIntervalStartTime(Date intervalStartTime) {
        this.intervalStartTime = intervalStartTime;
    }

    public Date getIntervalEndTime() {
        return intervalEndTime;
    }

    public void setIntervalEndTime(Date intervalEndTime) {
        this.intervalEndTime = intervalEndTime;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public List<CheckList> getCheckLists() {
        return checkLists;
    }

    public void setCheckLists(List<CheckList> checkLists) {
        this.checkLists = checkLists;
    }
}
