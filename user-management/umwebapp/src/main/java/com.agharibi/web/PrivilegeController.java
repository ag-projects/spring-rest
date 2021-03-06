package com.agharibi.web;

import com.agharibi.persistence.model.Privilege;
import com.agharibi.persistence.service.RawService;
import com.agharibi.service.PrivilegeService;
import com.agharibi.util.QueryConstants;
import com.agharibi.util.UmMappings;
import com.agharibi.web.controller.AbstractController;
import com.agharibi.web.controller.SortingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = UmMappings.PRIVILEGES)
public class PrivilegeController extends AbstractController<Privilege> implements SortingController<Privilege> {

    @Autowired
    private PrivilegeService privilegeService;

    @Override
    protected RawService<Privilege> getService() {
        return privilegeService;
    }

    @Override
    @ResponseBody
    @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY },
            method = RequestMethod.GET)
    public List<Privilege> findAllPaginatedAndSorted(
            @RequestParam(value = QueryConstants.PAGE) int page,
            @RequestParam(value = QueryConstants.SIZE) int size,
            @RequestParam(value = QueryConstants.SORT_BY) String sortBy,
            @RequestParam(value = QueryConstants.SORT_ORDER) String sortOrder) {

        return findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
    }

    @Override
    @ResponseBody
    @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE },
            method = RequestMethod.GET)
    public List<Privilege> findAllPaginated(
            @RequestParam(value = QueryConstants.PAGE) int page,
            @RequestParam(value = QueryConstants.SIZE) int size) {

        return findPaginatedInternal(page, size);
    }

    @Override
    @ResponseBody
    @RequestMapping(params = { QueryConstants.SORT_BY }, method = RequestMethod.GET)
    public List<Privilege> findAllSorted(
            @RequestParam(value = QueryConstants.SORT_BY)String sortBy,
            @RequestParam(value = QueryConstants.SORT_ORDER) String sortOrder) {

        return findAllSortedInternal(sortBy, sortOrder);
    }

    @Override
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Privilege> findAll(HttpServletRequest request) {
        return findAllInternal(request);
    }


    // find - one

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Privilege findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    // create

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Privilege resource) {
        createInternal(resource);
    }

    // update

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody final Privilege resource) {
        updateInternal(id, resource);
    }

    // delete

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        deleteByIdInternal(id);
    }
}
