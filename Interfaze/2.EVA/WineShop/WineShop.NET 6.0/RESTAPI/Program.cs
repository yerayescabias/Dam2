using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using RESTAPI.Data;
using RESTAPI.Services;
using Swashbuckle.Swagger;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
    //builder.Services.AddSwaggerGen(c =>
    //{
    //    c.SwaggerDoc("v1", new Info { title = "API WSVAP (WebSmartView)", version = "v1" });
    //    c.ResolveConflictingActions(apiDescriptions => apiDescriptions.First()); //This line
    //}); ;

//Gure konexioa injektatzen dugu
var connectionString = builder.Configuration.GetConnectionString("WineShopConnection");
builder.Services.AddDbContext<WineShopDbContext>(x => x.UseSqlServer(connectionString));

//Zerbitzuak injektatzeko
builder.Services.AddScoped<IArdoaService, ArdoaService>();
builder.Services.AddScoped<IEskualdeaService, EskualdeaService>();
builder.Services.AddScoped<ISaskiaAleaService, SaskiaAleaService>();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
//    app.UseSwaggerUI(c =>
//    {
////       c.SwaggerEndpoint("./v1/swagger.json", "RESTAPI v1"); //originally "./swagger/v1/swagger.json"
//        c.SwaggerEndpoint("/v1/swagger.json", "RESTAPI v1"); //originally "./swagger/v1/swagger.json"
//    });
}

app.UseDeveloperExceptionPage();

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
