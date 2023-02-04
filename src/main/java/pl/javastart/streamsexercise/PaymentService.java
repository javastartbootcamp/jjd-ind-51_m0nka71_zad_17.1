package pl.javastart.streamsexercise;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PaymentService {

    private PaymentRepository paymentRepository;
    private DateTimeProvider dateTimeProvider;

    PaymentService(PaymentRepository paymentRepository, DateTimeProvider dateTimeProvider) {
        this.paymentRepository = paymentRepository;
        this.dateTimeProvider = dateTimeProvider;
    }

    /*
    Znajdź i zwróć płatności posortowane po dacie malejąco
     */
    List<Payment> findPaymentsSortedByDateDesc() {
        List<Payment> payments = new ArrayList<>();
        return payments.stream()
                .map(p -> paymentRepository.findAll())
                .flatMap(List::stream)
                .sorted(Comparator.comparing(p -> dateTimeProvider.zonedDateTimeNow()))
                .collect(Collectors.toList());
    }

    /*
    Znajdź i zwróć płatności dla aktualnego miesiąca
     */
    List<Payment> findPaymentsForCurrentMonth() {
//        List<Payment> payments = new ArrayList<>();
//        return payments.stream()
//                .map(p -> paymentRepository.findAll())
//                .flatMap(List::stream)
//                .
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla wskazanego miesiąca
     */
    List<Payment> findPaymentsForGivenMonth(YearMonth yearMonth) {
        List<Payment> payments = new ArrayList<>();
        return payments.stream()
                .map(p -> paymentRepository.findAll())
                .flatMap(List::stream)
                .filter(p -> dateTimeProvider.equals(yearMonth))
                .collect(Collectors.toList());
    }

    /*
    Znajdź i zwróć płatności dla ostatnich X dzni
     */
    List<Payment> findPaymentsForGivenLastDays(int days) {
//        List<Payment> payments = new ArrayList<>();
//        return payments.stream()
//                .map(p -> paymentRepository.findAll())
//                .flatMap(List::stream)
//                .filter(p -> days)
//                .collect(Collectors.toList());
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności z jednym elementem
     */
    Set<Payment> findPaymentsWithOnePaymentItem() {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć nazwy produktów sprzedanych w aktualnym miesiącu
     */
    Set<String> findProductsSoldInCurrentMonth() {
        Set<String> products = new HashSet<>();
        return products.stream()
                .map(p -> paymentRepository.findAll())
                .flatMap(p -> p.stream())
                .filter(p -> dateTimeProvider)
                .collect(Collectors.toList());
        //throw new RuntimeException("Not implemented");
    }

    /*
    Policz i zwróć sumę sprzedaży dla wskazanego miesiąca
     */
    BigDecimal sumTotalForGivenMonth(YearMonth yearMonth) {

        throw new RuntimeException("Not implemented");
    }

    /*
    Policz i zwróć sumę przeyznanaych rabatów dla wskazanego miesiąca
     */
    BigDecimal sumDiscountForGivenMonth(YearMonth yearMonth) {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla użytkownika z podanym mailem
     */
    List<PaymentItem> getPaymentsForUserWithEmail(String userEmail) {
        List<PaymentItem> paymentItems = new ArrayList<>();
        return paymentItems.stream()
                .filter(p -> p.getName().equals(userEmail))
                .collect(Collectors.toList());
        //throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności, których wartość przekracza wskazaną granicę
     */
    Set<Payment> findPaymentsWithValueOver(int value) {
        throw new RuntimeException("Not implemented");
    }
}


