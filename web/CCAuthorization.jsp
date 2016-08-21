<%-- 
    Document   : DropInUI
    Created on : Aug 20, 2016, 6:54:43 PM
    Author     : -sergio-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src='//assets.codepen.io/assets/editor/live/console_runner-d0a557e5cb67f9cd9bbb9673355c7e8e.js'></script><script src='//assets.codepen.io/assets/editor/live/events_runner-21174b4c7273cfddc124acb0876792e0.js'></script><script src='//assets.codepen.io/assets/editor/live/css_live_reload_init-7618a0de08795409d8f6c9ef6805f7b2.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="canonical" href="http://codepen.io/braintree/pen/MyzXqG" />

        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
        <style class="cp-pen-styles">/* Uses Bootstrap stylesheets for styling, see linked CSS*/
            body {
                background-color: #fff;
            }

            .panel {
                width: 80%;
                margin: 2em auto;
            }

            .bootstrap-basic {
                background: white;
            }

            .panel-body {
                width: 90%;
                margin: 2em auto;
            }

            .helper-text {
                color: #8A6D3B;
                font-size: 12px;
                margin-top: 5px;
                height: 12px;
                display: block;
            }

            /* Braintree Hosted Fields styling classes*/
            .braintree-hosted-fields-focused { 
                border: 1px solid #0275d8;
                box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
            }

            .braintree-hosted-fields-focused.focused-invalid {
                border: 1px solid #ebcccc;
                box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(100,100,0,.6);
            }

            @media (max-width: 670px) {
                .form-group {
                    width: 100%;
                }

                .btn {
                    white-space: normal;
                }
            }</style>
    </head>
    <body>
        <a href="index.jsp">Back to index </a>
        <div class="panel panel-default bootstrap-basic">
            <form  action="processRequest" id="submitForm" method="post" style="margin-left: 30px "><br>
                <label for='price'>Item:</label><br>
                <input type="text" name="item" value="Buying a new phone" readonly/><br>
                <label for='price'>Name:</label><br>
                <input type="text" name="fname" value="Sergio" readonly/><br>
                <label for='price'>Last Name:</label><br>
                <input type="text" name="lname" value="Vilaseco-Romero" readonly/><br>
                <label for='price'>Address:</label><br>
                <input type="text" name="address" value="24 my street" readonly/><br>
                <label for='price'>County:</label><br>
                <input type="text" name="county" value="Louth" readonly/><br>
                <label for='price'>Country</label><br>
                <input type="text" name="county" value="Ireland" readonly/><br>
                <label for='price'>Price:</label><br>
                <input id="price" type="text" name="price" value="100.00" /><br>
                <input type='hidden' id="nonce" name='nonce' value=''/>
                <input type="hidden" name="action" value="ccauthorization" />
                <br><br>

            </form>
        </div>

        <!-- Bootstrap inspired Braintree Hosted Fields example -->
        <div class="panel panel-default bootstrap-basic">
            <div class="panel-heading">
                <h3 class="panel-title">Enter Card Details</h3>
            </div>
            <form class="panel-body">
                <div class="row">
                    <div class="form-group col-xs-8">
                        <label class="control-label">Card Number</label>
                        <!--  Hosted Fields div container -->
                        <div class="form-control" id="card-number"></div>
                        <span class="helper-text"></span>
                    </div>
                    <div class="form-group col-xs-4">
                        <div class="row">
                            <label class="control-label col-xs-12">Expiration Date</label>
                            <div class="col-xs-6">
                                <!--  Hosted Fields div container -->
                                <div class="form-control" id="expiration-month"></div>
                            </div>
                            <div class="col-xs-6">
                                <!--  Hosted Fields div container -->
                                <div class="form-control" id="expiration-year"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-6">
                        <label class="control-label">Security Code</label>
                        <!--  Hosted Fields div container -->
                        <div class="form-control" id="cvv"></div>
                    </div>
                    <div class="form-group col-xs-6">
                        <label class="control-label">Zipcode</label>
                        <!--  Hosted Fields div container -->
                        <div class="form-control" id="postal-code"></div>
                    </div>
                </div>


                <button value="submit" id="submit" class="btn btn-success btn-lg center-block">Authorize with <span id="card-type">Card</span></button>
            </form>

            <!-- Load the required client component. -->
            <script src="https://js.braintreegateway.com/web/3.0.0/js/client.min.js"></script>

            <!-- Load Hosted Fields component. -->
            <script src="https://js.braintreegateway.com/web/3.0.0/js/hosted-fields.min.js"></script>
            <script src='//assets.codepen.io/assets/common/stopExecutionOnTimeout-53beeb1a007ec32040abaf4c9385ebfc.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js'></script><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
            <script>braintree.client.create({authorization: '<%=(String) session.getAttribute("clientToken")%>'}, function (err, clientInstance) {
                    if (err) {
                        console.error(err);
                        return;
                    }
                    braintree.hostedFields.create({
                        client: clientInstance,
                        styles: {
                            'input': {
                                'font-size': '14px',
                                'font-family': 'helvetica, tahoma, calibri, sans-serif',
                                'color': '#3a3a3a'
                            },
                            ':focus': {'color': 'black'}
                        },
                        fields: {
                            number: {
                                selector: '#card-number',
                                placeholder: '4111 1111 1111 1111'
                            },
                            cvv: {
                                selector: '#cvv',
                                placeholder: '123'
                            },
                            expirationMonth: {
                                selector: '#expiration-month',
                                placeholder: 'MM'
                            },
                            expirationYear: {
                                selector: '#expiration-year',
                                placeholder: 'YY'
                            },
                            postalCode: {
                                selector: '#postal-code',
                                placeholder: '90210'
                            }
                        }
                    }, function (err, hostedFieldsInstance) {
                        if (err) {
                            console.error(err);
                            return;
                        }
                        hostedFieldsInstance.on('validityChange', function (event) {
                            var field = event.fields[event.emittedBy];
                            if (field.isValid) {
                                if (event.emittedBy === 'expirationMonth' || event.emittedBy === 'expirationYear') {
                                    if (!event.fields.expirationMonth.isValid || !event.fields.expirationYear.isValid) {
                                        return;
                                    }
                                } else if (event.emittedBy === 'number') {
                                    $('#card-number').next('span').text('');
                                }
                                $(field.container).parents('.form-group').addClass('has-success');
                            } else if (field.isPotentiallyValid) {
                                $(field.container).parents('.form-group').removeClass('has-warning');
                                $(field.container).parents('.form-group').removeClass('has-success');
                                if (event.emittedBy === 'number') {
                                    $('#card-number').next('span').text('');
                                }
                            } else {
                                $(field.container).parents('.form-group').addClass('has-warning');
                                if (event.emittedBy === 'number') {
                                    $('#card-number').next('span').text('Looks like this card number has an error.');
                                }
                            }
                        });
                        hostedFieldsInstance.on('cardTypeChange', function (event) {
                            if (event.cards.length === 1) {
                                $('#card-type').text(event.cards[0].niceType);
                            } else {
                                $('#card-type').text('Card');
                            }
                        });
                        $('.panel-body').submit(function (event) {
                            event.preventDefault();
                            hostedFieldsInstance.tokenize(function (err, payload) {
                                if (err) {
                                    console.error(err);
                                    return;
                                }
                                var nonce = payload.nonce;
                                
                                //window.alert(nonce);
                                
                                document.getElementById("nonce").value = nonce;
                                document.getElementById("submitForm").submit();
                            });
                        });
                    });
                });
                //# sourceURL=pen.js
            </script>
    </body>
</html>
