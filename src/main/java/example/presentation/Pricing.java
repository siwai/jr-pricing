package example.presentation;

import example.application.service.FareService;
import example.domain.model.attempt.Attempt;
import example.domain.model.bill.Amount;
import example.domain.model.bill.Bill;
import example.domain.model.specification.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * 料金計算コントローラ
 */
@RestController
@RequestMapping("/api/pricing")
@Api(tags="JR新幹線 料金計算")
public class Pricing {

    FareService fareService;

    public Pricing(FareService fareService) {
        this.fareService = fareService;
    }

    @GetMapping
    @ApiOperation("料金計算")
    String pricing(
            @ApiParam(value="adults", defaultValue = "1") @RequestParam int adult,
            @ApiParam(value="children", defaultValue = "1") @RequestParam int child,
            @ApiParam(value="departureDate", defaultValue = "2020-12-15") @RequestParam DepartureDate departureDate,
            @ApiParam(value="destination", defaultValue = "新大阪") @RequestParam Destination destination,
            @ApiParam(value="seatType", defaultValue = "指定席") @RequestParam SeatType seatType,
            @ApiParam(value="trainType", defaultValue = "ひかり") @RequestParam TrainType trainType,
            @ApiParam(value="ticketType", defaultValue = "片道") @RequestParam TicketType ticketType
            ) {

        Attempt attempt = new Attempt(adult, child, departureDate, destination, seatType, trainType, ticketType);
        Amount amount = fareService.amountFor(attempt);
        return new Bill(attempt, amount).toString();
    }
}
