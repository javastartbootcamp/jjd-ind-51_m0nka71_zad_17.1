package pl.javastart.streamsexercise;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.ZonedDateTime;
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
        return paymentRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Payment::getPaymentDate).reversed())
                .collect(Collectors.toList());
    }

    /*
    Znajdź i zwróć płatności dla aktualnego miesiąca
     */
    List<Payment> findPaymentsForCurrentMonth() {
        ZonedDateTime zonedDateTime = dateTimeProvider.zonedDateTimeNow();
        return paymentRepository.findAll()
                .stream()
                .filter(payment -> payment.getPaymentDate().getMonth().equals(zonedDateTime.getMonth()))
                .collect(Collectors.toList());
    }

    /*
    Znajdź i zwróć płatności dla wskazanego miesiąca
     */
    List<Payment> findPaymentsForGivenMonth(YearMonth yearMonth) {
        return paymentRepository.findAll()
                .stream()
                .filter(payment -> payment.getPaymentDate().getMonth().equals(yearMonth.getMonth()))
                .collect(Collectors.toList());
    }

    /*
    Znajdź i zwróć płatności dla ostatnich X dzni
     */
    List<Payment> findPaymentsForGivenLastDays(int days) {
//        return paymentRepository.findAll()
//                .stream()
//                .filter(payment -> payment.getPaymentDate())
//                .collect(Collectors.toList());
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności z jednym elementem
     */
    Set<Payment> findPaymentsWithOnePaymentItem() {
        return paymentRepository.findAll().stream()
                .filter(payment -> payment.getPaymentItems().size() == 1)
                .collect(Collectors.toSet());
    }

    /*
    Znajdź i zwróć nazwy produktów sprzedanych w aktualnym miesiącu
     */
    Set<String> findProductsSoldInCurrentMonth() {
        ZonedDateTime zonedDateTime = dateTimeProvider.zonedDateTimeNow();
        return paymentRepository.findAll()
                .stream()
                .filter(payment -> payment.getPaymentDate().getMonth().equals(zonedDateTime.getMonth()))
                .map(Payment::getPaymentItems)
                .flatMap(Collection::stream)
                .map(PaymentItem::getName)
                .collect(Collectors.toSet());
    }

    /*
    Policz i zwróć sumę sprzedaży dla wskazanego miesiąca
     */
    BigDecimal sumTotalForGivenMonth(YearMonth yearMonth) {
//        return paymentRepository.findAll()
//                .stream()
//                .map(Payment::getPaymentItems)
//                .flatMap(Collection::stream)
//                .map(PaymentItem::getFinalPrice)
//                .reduce(BigDecimal::add).get()
        throw new RuntimeException("Not implemented");
    }

    /*
    Policz i zwróć sumę przeyznanaych rabatów dla wskazanego miesiąca
     */
    BigDecimal sumDiscountForGivenMonth(YearMonth yearMonth) {
//        return paymentRepository.findAll().stream()
//                .filter(payment -> payment.getPaymentDate().getMonth().equals(yearMonth.getMonth()))
//                .map(Payment::getPaymentItems)
//                .flatMap(Collection::stream)
//                .filter(paymentItem ->
//                .collect(Collectors.toList();
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla użytkownika z podanym mailem
     */
    List<PaymentItem> getPaymentsForUserWithEmail(String userEmail) {
        return paymentRepository.findAll()
                .stream()
                .filter(p -> p.getUser().getEmail().equals(userEmail))
                .flatMap(payment -> payment.getPaymentItems().stream())
                .collect(Collectors.toList());
    }

    /*
    Znajdź i zwróć płatności, których wartość przekracza wskazaną granicę
     */
    Set<Payment> findPaymentsWithValueOver(int value) {
//        BigDecimal bigDecimal = BigDecimal.valueOf(value);
//        return paymentRepository.findAll()
//                .stream()
//                .map(Payment::getPaymentItems)
//                .flatMap(Collection::stream)
//                .filter(paymentItem -> paymentItem.getFinalPrice().compareTo(bigDecimal))
//                .collect(Collectors.toSet());
        throw new RuntimeException("Not implemented");
    }
}


