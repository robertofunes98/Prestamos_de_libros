package sv.company.unicaes.menuprincipal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

import sv.company.unicaes.menuprincipal.activities_prestamista.LibrosPrestamo;
import sv.company.unicaes.menuprincipal.activities_prestamista.MisLibros;
import sv.company.unicaes.menuprincipal.activities_prestamista.RegistroLibros;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        cargarMenu(navigationView);
    }

    private void cargarMenu(NavigationView navigationView) {
        if(Variables.user.getUserType()==0)
            navigationView.getMenu().findItem(R.id.opc_menu_prestamistas).setVisible(false);
        else if(Variables.user.getUserType()==1)
            navigationView.getMenu().findItem(R.id.opc_menu_prestatarios).setVisible(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;
        switch (id)
        {
            case R.id.opc_registrar_libros:
                intent=new Intent(MainActivity.this, RegistroLibros.class);
                startActivity(intent);
                break;

            case R.id.opc_mis_libros:
                intent = new Intent(MainActivity.this, MisLibros.class);
                startActivity(intent);
                break;

            case R.id.opc_libros_prestamos:
                intent = new Intent(MainActivity.this, LibrosPrestamo.class);
                startActivity(intent);
                break;

            default:
                Toast.makeText(this, "fallo", Toast.LENGTH_SHORT).show();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
