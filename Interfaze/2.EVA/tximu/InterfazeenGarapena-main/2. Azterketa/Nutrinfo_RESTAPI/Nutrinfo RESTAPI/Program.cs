using Microsoft.EntityFrameworkCore;
using Nutrinfo_RESTAPI.Data;
using Nutrinfo_RESTAPI.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

//Gure konexioa injektatzen dugu
var connectionString = builder.Configuration.GetConnectionString("NutrinfoConnection");
builder.Services.AddDbContext<NutrinfoDbContext>(x => x.UseSqlServer(connectionString));

//Zerbitzuak injektatzeko
builder.Services.AddScoped<IElikagaiaService, ElikagaiaService>();
builder.Services.AddScoped<IBerriaService, BerriaService>();
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
