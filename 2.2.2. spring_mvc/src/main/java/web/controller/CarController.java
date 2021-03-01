package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.CarDao;
import web.models.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String index(HttpServletRequest request, Model model) {

        String str = request.getParameter("count");
        if (str == null) {
            model.addAttribute("cars", carDao.index());
        } else {
            int numb = Integer.parseInt(str);

            if (numb >= 5) {
                model.addAttribute("cars", carDao.index());
            } else {
                List<Car> carsList = new ArrayList<>();
                for (int i = 0; i < numb; i++) {
                    carsList.add(carDao.index().get(i));
                }
                model.addAttribute("cars", carsList);
            }
            System.out.println(numb);
        }

        return "car";
    }

}
