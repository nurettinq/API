package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingPojo {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDatePojo bookingdates;
    private String additionalneeds;


    public BookingPojo(String firstename, String lastname,Integer totolprice, Boolean depositpaid,  BookingDatePojo bookingdates ,String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totolprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public BookingPojo() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdditionalsneeds() {
        return additionalneeds;
    }

    public void setAdditionalsneeds(String additionalsneeds) {
        this.additionalneeds = additionalsneeds;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public BookingDatePojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatePojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "BookingPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", additionalsneeds='" + additionalneeds + '\'' +
                ", depositpaid=" + depositpaid +
                ", totolprice=" + totalprice +
                ", bookingdates=" + bookingdates +
                '}';
    }
}
