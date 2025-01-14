using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using RESTAPI.Data;
using RESTAPI.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

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
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
