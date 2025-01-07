// Document Ready
$(document).ready(function () {

    // Function to format numbers as currency (e.g., $12.00)
    function formatCurrency(value) {
        return "$" + value.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
    }

    // 🛒 Handle Add to Cart
    $(".AddLink").click(function (e) {
        e.preventDefault();

        var recordToAdd = $(this).attr("data-id");
        var kantitatea = parseInt($("#item-count-" + recordToAdd).text());
        var salneurria = parseFloat($(this).attr("data-salneurria"));
        var guztira = parseFloat($("#cart-total").text().replace(/[^\d.-]/g, ''));

        if (recordToAdd !== '') {
            $.ajax({
                url: "/Saskia/SaskiaGehituAjax",
                type: "POST",
                data: {
                    id: recordToAdd,
                    kantitatea: kantitatea,
                    salneurria: salneurria,
                    guztira: guztira
                },
                success: function (data) {
                    if (data) {
                        // Update the quantity for the added item
                        $("#item-count-" + recordToAdd).text(data.kantitatea.toString());

                        // Update the subtotal for this item
                        var newSubtotal = data.kantitatea * data.salneurria;
                        $("#row-" + recordToAdd + " td:last-child").text(formatCurrency(newSubtotal));

                        // Recalculate the total cart amount by summing all item subtotals
                        var total = 0;
                        $(".table tbody tr").each(function () {
                            var subtotal = parseFloat($(this).find("td:last-child").text().replace(/[^\d.-]/g, ''));
                            total += subtotal;
                        });

                        // Update the total
                        $("#cart-total").text(formatCurrency(total));

                        // Display success message
                        $("#update-message").html(`<div class="alert alert-success">${data.mezua}</div>`);

                        setTimeout(() => {
                            $("#update-message").empty();
                        }, 3000);
                    }
                },
                error: function (xhr, status, error) {
                    console.error("Error adding to cart:", error);
                    $("#update-message").html(`<div class="alert alert-danger">Errorea: ${error}</div>`);
                }
            });
        }
    });

    // ➖ Handle Remove from Cart
    $(".SubtractLink").click(function (e) {
        e.preventDefault();

        var recordToSubtract = $(this).attr("data-id");
        var kantitatea = parseInt($("#item-count-" + recordToSubtract).text());
        var salneurria = parseFloat($(this).attr("data-salneurria"));
        var guztira = parseFloat($("#cart-total").text().replace(/[^\d.-]/g, ''));

        if (recordToSubtract !== '') {
            $.ajax({
                url: "/Saskia/SaskiaKenduAjax",
                type: "POST",
                data: {
                    id: recordToSubtract,
                    kantitatea: kantitatea,
                    salneurria: salneurria,
                    guztira: guztira
                },
                success: function (data) {
                    if (data) {
                        if (data.kendu) {
                            // Remove the item row if quantity hits zero
                            $("#row-" + recordToSubtract).remove();
                        } else {
                            // Update quantity if not removed
                            $("#item-count-" + recordToSubtract).text(data.kantitatea.toString());

                            // Update the subtotal for this item
                            var newSubtotal = data.kantitatea * data.salneurria;
                            $("#row-" + recordToSubtract + " td:last-child").text(formatCurrency(newSubtotal));
                        }

                        // Recalculate the total cart amount by summing all item subtotals
                        var total = 0;
                        $(".table tbody tr").each(function () {
                            var subtotal = parseFloat($(this).find("td:last-child").text().replace(/[^\d.-]/g, ''));
                            total += subtotal;
                        });

                        // Update the total
                        $("#cart-total").text(formatCurrency(total));

                        // Display success message
                        $("#update-message").html(`<div class="alert alert-success">${data.mezua}</div>`);

                        setTimeout(() => {
                            $("#update-message").empty();
                        }, 3000);
                    }
                },
                error: function (xhr, status, error) {
                    console.error("Error removing from cart:", error);
                    $("#update-message").html(`<div class="alert alert-danger">Errorea: ${error}</div>`);
                }
            });
        }
    });

});