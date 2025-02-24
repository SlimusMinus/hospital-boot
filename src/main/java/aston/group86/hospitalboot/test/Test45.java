package aston.group86.hospitalboot.test;

import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;

public class Test45 {

}


/*public class SeatBookingService {

  @Autowired
  private SeatBookingRepository seatBookingRepository;
  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private TariffClient tariffClient;
  @Autowired
  private CustomerClient customerClient;
  @Autowired
  private PaymentClient paymentClient;

  //    Бронирование
//    @param seatCode код места (например 19А)
//    @param ticketId ид билета
  @Transactional
  private static void bookSeat(String seatCode, UUID ticketId) {
    var ticket = ticketRepository.findById(ticketId);
    //бронируем
    var seatBooking = new SeatBooking(seatCode, ticket.get().getFlightId(), ticketId, BoolingStatus.BOOKED);
    seatBookingRepository.save(seatBooking);

    //ищем базовый тариф для выбранного места в самолете
    var basePrice = tariffClient.getBasePrice(ticket.get().getPlaneModel(), seatCode);
    //ищем данные о клиенте
    Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    var userData = customerClient.getCustomer(userId);
    System.out.println(
        "Найден пользователь " + userData.getFio() + " Номер документа " + userData.getDocument());
    var price = basePrice;
    if (userData.getTariff() == "PREMIUM") {
      //скидка 50%
      price = basePrice * 0.5d;
    }
    if (userData.getTariff() == "ULTRA") {
      //скидка 20%
      price = basePrice * 0.8d;
    }
    var invoce = new Invoce(price, ticketId, userId);
    // выставляем платежку
    paymentClient.sendInvoce(invoce);
    System.out.println("Счет выставлен");
  }*/