package com.agharibi.web;

import com.agharibi.persistence.model.Role;
import com.agharibi.persistence.service.RawService;
import com.agharibi.service.RoleService;
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
@RequestMapping(value = UmMappings.ROLES)
public class RoleController extends AbstractController<Role> implements SortingController<Role> {

    @Autowired
    private RoleService roleService;

    @Override
    protected RawService<Role> getService() {
        return roleService;
    }

    @Override
    @ResponseBody
    @RequestMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY },
            method = RequestMethod.GET)
    public List<Role> findAllPaginatedAndSorted(
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
    public List<Role> findAllPaginated(
            @RequestParam(value = QueryConstants.PAGE) int page,
            @RequestParam(value = QueryConstants.SIZE) int size) {
        return findPaginatedInternal(page, size);
    }

    @Override
    @ResponseBody
    @RequestMapping(params = { QueryConstants.SORT_BY },
            method = RequestMethod.GET)
    public List<Role> findAllSorted(
            @RequestParam(value = QueryConstants.SORT_BY) String sortBy,
            @RequestParam(value = QueryConstants.SORT_ORDER) String sortOrder) {
        return findAllSortedInternal(sortBy, sortOrder);
    }

    @Override
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Role> findAll(HttpServletRequest request) {
        return findAllInternal(request);
    }

    // find - one

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Role findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    // create

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Role resource) {
        createInternal(resource);
    }

    // update

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody final Role resource) {
        updateInternal(id, resource);
    }

    // delete

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        deleteByIdInternal(id);
    }

}
