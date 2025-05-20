import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Usuario;

public class TaskHubTest {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.
                createEntityManagerFactory(
                        "PU"
                );
        EntityManager em = emf.createEntityManager();

        try {
            // Criar Usuários
            Usuario usuario1 =
                    new Usuario(1, "Dick Vigarista"
                            , "dickvigarista@gmail.com"
                            , "dick123");
            Usuario usuario2 =
                    new Usuario(2, "Muttley"
                            , "muttley@gmail.com"
                            , "muttley123");

            // Persistir Usuários
            em.getTransaction().begin();
            em.persist(usuario1);
            em.persist(usuario2);
            em.getTransaction().commit();

        } finally {
            em.close();
            emf.close();
        }
    }
}
