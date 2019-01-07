package com.wonder.bring.api;

import com.wonder.bring.dto.MenuDetail;
import com.wonder.bring.dto.StoreMenu;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wonder.bring.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Create by YoungEun on 2018-12-29.
 */

@Slf4j
@RequestMapping("stores/{storeIdx}")
@RestController
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 메뉴 리스트 조회
     * @param storeIdx 해당 매장
     * @return 메뉴 리스트
     */
    @GetMapping("menu")
    public ResponseEntity getMenuList(@PathVariable(value = "storeIdx") final int storeIdx) {
        try{
            DefaultRes<StoreMenu> defaultRes = menuService.findMenuByStoreIdx(storeIdx);

            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 메뉴 상세 정보 조회
     * @param storeIdx
     * @param menuIdx
     * @return 메뉴 상세 정보
     */
    @GetMapping("menu/{menuIdx}")
    public ResponseEntity getMenuDetail(@PathVariable(value = "storeIdx") final int storeIdx,
                                        @PathVariable(value = "menuIdx") final int menuIdx) {
        try {
            DefaultRes<MenuDetail> defaultRes = menuService.findDetailMenu(storeIdx, menuIdx);

            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
