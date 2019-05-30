package controllers;

import com.google.gson.Gson;
import entities.Transaction;
import entities.TransactionException;
import services.AccountingService;

import static spark.Spark.*;

public class AccountingController {

    public static void main(String[] args) {

        final AccountingService accountingService = new AccountingService();

        get("/", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(accountingService.getTransactions());
        });

        get("/:id", (request, response) -> {
            try {
                Transaction transaction = accountingService.getTransactionById(request.params(":id"));
                return new Gson().toJson(transaction);
            } catch(TransactionException ex) {
                response.status(ex.getCode());
                return new Gson().toJson(ex.getErrorMessage());
            }
        });

        post("/", (request, response) -> {
            response.type("application/json");
            Transaction transaction = new Gson().fromJson(request.body(), Transaction.class);
            try {
                Transaction createdTransaction = accountingService.addTransaction(transaction);
                return new Gson().toJson(createdTransaction);
            } catch(TransactionException ex) {
                response.status(ex.getCode());
                return new Gson().toJson(ex.getErrorMessage());
            }
        });

        options("/*",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
    }
}
