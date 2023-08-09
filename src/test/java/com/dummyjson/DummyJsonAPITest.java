package com.dummyjson;

import com.azure.core.annotation.Post;
import com.zebrunner.carina.core.IAbstractTest;
import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.api.DeleteUserMethod;
import com.zebrunner.carina.demo.api.GetUserMethods;
import com.zebrunner.carina.demo.api.PostUserMethod;
import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

public class DummyJsonAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner="cchen484")
    public void testPostTodo() {
        PostTodoMethod api = new PostTodoMethod();
        api.setProperties("api/todos/todo.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner="cchen484")
    public void testGetTodo() {
        GetTodoMethod api = new GetTodoMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner="cchen484")
    public void testPutTodo() {
        PutTodoMethod api = new PutTodoMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner="cchen484")
    public void testDeleteTodo() {
        DeleteTodoMethod api = new DeleteTodoMethod();
        api.setProperties("api/todos/todo.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

}
